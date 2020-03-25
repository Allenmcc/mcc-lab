package date;

import java8.Person;
import org.junit.Test;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.DateFormatter;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class SimpleDateTest {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyMMdd");


        //时间可变，线程不安全
        Callable<Date> task = new Callable<Date>() {
            @Override
            public Date call() throws Exception {
                //线程不安全
//                return sdf.parse("20190205");
                return DateFormatThreadLocal.convert("20190205");
            }
        };

        ExecutorService pool = Executors.newFixedThreadPool(10);


        List<Future<Date>> futures = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            futures.add(pool.submit(task));

        }
        for (Future<Date> future : futures) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }

        pool.shutdown();
    }


    /**
     * LocalDate（日期） LocalTime（时间） LocalDateTime（日期时间） 类的实例是不可变对象
     */
    @Test
    public void testJava8Date() {

        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyMMdd");

        //每个线程返回一个LocalDate，线程安全
        Callable<LocalDate> task = new Callable<LocalDate>() {
            @Override
            public LocalDate call() throws Exception {
                return LocalDate.parse("20190205", sdf);
            }
        };

        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future<LocalDate>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            futures.add(pool.submit(task));

        }
        for (Future<LocalDate> future : futures) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }

        pool.shutdown();
    }

    /**
     * 人读
     * LocalDate（日期） LocalTime（时间） LocalDateTime（日期时间） 类的实例是不可变对象
     */
    @Test
    public void testLocalDateTime() {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        LocalDateTime localDateTime = LocalDateTime.of(2019, 02, 05, 13, 22, 23);
        System.out.println(localDateTime);

        LocalDateTime localDateTime1 = ldt.plusYears(2);
        System.out.println(localDateTime1);

        //新的 LocalDateTime 线程安全
        LocalDateTime localDateTime2 = ldt.minusMinutes(2);
        System.out.println(localDateTime2);
        System.out.println(localDateTime2.getYear());
        System.out.println(localDateTime2.getSecond());

    }

    /**
     * 机器读
     * Instant 时间戳：以Unix 元年，1970年1月1日 00:00:00 到某个时间直接的毫秒值
     */
    @Test
    public void testInstant() {
        Instant instant = Instant.now(); //默认是UTC时区 （格林。。）
        System.out.println(instant);


        //输出偏移时间2020-03-01T18:58:06.081+08:00
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        //输出时间戳
        System.out.println(instant.toEpochMilli());

        //时间戳+60秒
        Instant instant1 = Instant.ofEpochSecond(60);
        System.out.println(instant1);

    }


    /**
     * 间隔
     * Duration ：计算两个时间直接的间隔
     * Period：计算两个日期之前的间隔
     */
    @Test
    public void testDuration() {

        Instant instant = Instant.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant instant1 = Instant.now();
        Duration duration = Duration.between(instant, instant1);
        //PT1.002S
        System.out.println(duration);
        //1004
        System.out.println(duration.toMillis());


        LocalTime localTime = LocalTime.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LocalTime localTime1 = LocalTime.now();
        Duration duration1 = Duration.between(localTime, localTime1);
        System.out.println(duration1.toMillis());


        LocalDate localDate = LocalDate.of(2020, 1, 1);
        LocalDate localDate2 = LocalDate.now();
        Period period = Period.between(localDate, localDate2);

        System.out.println(period);
        System.out.println(period.getDays());
        System.out.println(period.getMonths());
    }

    /**
     * TemporalAdjuster ： 时间校正器
     */
    @Test
    public void testAdjust() {

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        //基于此月-日的请求日的月日
        LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(15);
        System.out.println(localDateTime1);

        //下个星期5
        LocalDateTime localDateTime2 = localDateTime.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        System.out.println(localDateTime2);

        //自定义：下一个工作日

        LocalDateTime localDateTime4 = localDateTime.with((l) -> {
            LocalDateTime localDateTime3 = (LocalDateTime)l;
            DayOfWeek dayOfWeek = localDateTime3.getDayOfWeek();
            if (dayOfWeek.equals(DayOfWeek.FRIDAY)) {
                return localDateTime3.plusDays(3);
            } else if (dayOfWeek.equals(DayOfWeek.SATURDAY)) {
                return localDateTime3.plusDays(2);
            } else {
                return localDateTime3.plusDays(1);
            }
        });
        System.out.println(localDateTime4);
    }

    /**
     * DateTimeFormatter : 格式化时间/日期
     */
    @Test
    public void test(){

        DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_DATE;
        LocalDateTime localDateTime = LocalDateTime.now();
//        System.out.println(localDateTime.format(dateFormatter));
        System.out.println(dateFormatter.format(localDateTime));

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");

        System.out.println(dateTimeFormatter.format(localDateTime));

    }

    /**
     * ZoneDate ZoneTime ZoneDateTime
     */
    @Test
    public void testZone(){
        //查看时区
        Set<String> set = ZoneId.getAvailableZoneIds();
        set.forEach(System.out::println);

        //某个时区的时间
        LocalDateTime ldt = LocalDateTime.now(ZoneId.of("Europe/Tallinn"));
        System.out.println(ldt);

        LocalDateTime ldt2 =LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        ZonedDateTime zdt = ldt2.atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(zdt);
    }

}
