package threadTest;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.*;


/**
 * CompletableFuture的命名规则
 * xxx():继续在已有的线程中执行
 * xxxAsync():用Executor的新线程执行
 *
 * CompletableFuture 对象可以制定异步处理流程
 * thenAccept()处理正常结果
 * exceptional处理异常结果
 * thenApplyAsync()用于串行化另一个CompletableFuture
 * anyOf/allOf用于并行化两个CompletableFuture
 *
 * https://www.jianshu.com/p/6bac52527ca4
 */
public class ComPleableFutureTest {


    //无返回值runAsync
    @Test
    public void runAsync(){
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }
            System.out.println("run end ...");
        });

        try {
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    //有返回值supplyAsync
    @Test
    public void   supplyAsync(){
        CompletableFuture<Long> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }
            System.out.println("run end ...");
            return System.currentTimeMillis();
        });

        long time = 0;
        try {
            time = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("time = "+time);
    }

    @Test
    public void whenComplete(){
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }
            if(new Random().nextInt()%2>=0) {
                System.out.println("1 :"+Thread.currentThread());
                int i = 12/0;
            }
            System.out.println("run end ...");
        });

        //whenComplete是执行当前任务的线程执行继续执行 whenComplete 的任务。
       // whenCompleteAsync：是执行把 whenCompleteAsync 这个任务继续提交给线程池来进行执行。
        //whenComplete不会阻塞主线程,任务执行后的回掉
        future.whenComplete(new BiConsumer<Void, Throwable>() {
            @Override
            public void accept(Void t, Throwable action) {
                System.out.println("whenComplete :"+Thread.currentThread());
                System.out.println("执行完成！");
            }

        });

//        future.whenComplete((t,action)->{
//            System.out.println("whenComplete :"+Thread.currentThread());
//            System.out.println("执行完成！");
//        });

        System.out.println("主线程执行中");
        future.exceptionally(new Function<Throwable, Void>() {
            @Override
            public Void apply(Throwable t) {
                System.out.println("执行失败！"+t.getMessage());
                return null;
            }
        });

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    //第二个任务依赖第一个任务的结果。
    @Test
    public void thenApply(){
        CompletableFuture<Long> future = CompletableFuture.supplyAsync(new Supplier<Long>() {
            @Override
            public Long get() {
                long result = new Random().nextInt(100);
                System.out.println("1"+Thread.currentThread());
                System.out.println("result1="+result);
                return result;
            }
        }).thenApply(new Function<Long, Long>() {
            @Override
            public Long apply(Long t) {
                long result = t*5;
                System.out.println("2"+Thread.currentThread());
                System.out.println("result2="+result);
                return result;
            }
        });

        long result = 0;
        try {
            result = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }


    /**
     * handle 是执行任务完成时对结果的处理。
     * handle 方法和 thenApply 方法处理方式基本一样。不同的是 handle 是在任务完成后再执行，还可以处理异常的任务。
     * thenApply 只可以执行正常的任务，任务出现异常则不执行 thenApply 方法。
     *
     */
    @Test
    public void handle(){
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(new Supplier<Integer>() {

            @Override
            public Integer get() {
                int i= 10/0;
                return new Random().nextInt(10);
            }
        }).handle(new BiFunction<Integer, Throwable, Integer>() {
            @Override
            public Integer apply(Integer param, Throwable throwable) {
                int result = -1;
                if(throwable==null){
                    result = param * 2;
                }else{
                    System.out.println(throwable.getMessage());
                }
                return result;
            }
        });
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


    //接收任务的处理结果，并消费处理，无返回结果。
    @Test
    public  void thenAccept() throws Exception{
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return new Random().nextInt(10);
            }
        }).thenAccept(integer -> {
            System.out.println(integer);
        });
        future.get();
    }

    //该方法同 thenAccept 方法类似。不同的是上个任务处理完成后，并不会把计算的结果传给 thenRun 方法。
    // 只是处理玩任务后，执行 thenAccept 的后续操作。
    @Test
    public  void thenRun() throws Exception{
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return new Random().nextInt(10);
            }
        }).thenRun(() -> {
            System.out.println("thenRun ...");
        });
        future.get();
    }


    //thenCombine 会把 两个 CompletionStage 的任务都执行完成后，把两个任务的结果一块交给 thenCombine 来处理。
    @Test
    public   void thenCombine() throws Exception {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                return "hello";
            }
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                return "world";
            }
        });
        CompletableFuture<String> result = future1.thenCombine(future2, new BiFunction<String, String, String>() {
            @Override
            public String apply(String t, String u) {
                return t+" "+u;
            }
        });

        CompletableFuture<String> result2 = future1.thenCombine(future2, (t1,t2)->t1+" "+t2);
        System.out.println(result.get());
        System.out.println(result2.get());
    }


    //当两个CompletionStage都执行完成后，把结果一块交给thenAcceptBoth来进行消耗
    @Test
    public void thenAcceptBoth() throws Exception {
        CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int t = new Random().nextInt(3);
                try {
                    TimeUnit.SECONDS.sleep(t);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("f1="+t);
                return t;
            }
        });

        CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int t = new Random().nextInt(3);
                try {
                    TimeUnit.SECONDS.sleep(t);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("f2="+t);
                return t;
            }
        });
        f1.thenAcceptBoth(f2, new BiConsumer<Integer, Integer>() {
            @Override
            public void accept(Integer t, Integer u) {
                System.out.println("f1="+t+";f2="+u+";");
            }
        });
    }

    //两个CompletionStage，谁执行返回的结果快，我就用那个CompletionStage的结果进行下一步的转化操作。
    @Test
    public void applyToEither() throws Exception {
        CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int t = new Random().nextInt(3);
                try {
                    TimeUnit.SECONDS.sleep(t);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("f1="+t);
                return t;
            }
        });
        CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int t = new Random().nextInt(3);
                try {
                    TimeUnit.SECONDS.sleep(t);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("f2="+t);
                return t;
            }
        });

        CompletableFuture<Integer> result = f1.applyToEither(f2, new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer t) {
                System.out.println(t);
                return t * 2;
            }
        });

        System.out.println(result.get());
    }

    //两个CompletionStage，谁执行返回的结果快，我就用那个CompletionStage的结果进行下一步的消耗操作。
    @Test
    public void acceptEither() throws Exception {
        CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int t = new Random().nextInt(3);
                try {
                    TimeUnit.SECONDS.sleep(t);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("f1="+t);
                return t;
            }
        });

        CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int t = new Random().nextInt(3);
                try {
                    TimeUnit.SECONDS.sleep(t);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("f2="+t);
                return t;
            }
        });
        f1.acceptEither(f2, new Consumer<Integer>() {
            @Override
            public void accept(Integer t) {
                System.out.println(t);
            }
        });
    }

    //两个CompletionStage，任何一个完成了都会执行下一步的操作（Runnable）
    @Test
    public void runAfterEither() throws Exception {
        CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int t = new Random().nextInt(3);
                try {
                    TimeUnit.SECONDS.sleep(t);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("f1="+t);
                return t;
            }
        });

        CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int t = new Random().nextInt(3);
                try {
                    TimeUnit.SECONDS.sleep(t);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("f2="+t);
                return t;
            }
        });
        f1.runAfterEither(f2, new Runnable() {

            @Override
            public void run() {
                System.out.println("上面有一个已经完成了。");
            }
        });
    }


    //两个CompletionStage，都完成了计算才会执行下一步的操作（Runnable）
    @Test
    public void runAfterBoth() throws Exception {
        CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int t = new Random().nextInt(3);
                try {
                    TimeUnit.SECONDS.sleep(t);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("f1="+t);
                return t;
            }
        });

        CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int t = new Random().nextInt(3);
                try {
                    TimeUnit.SECONDS.sleep(t);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("f2="+t);
                return t;
            }
        });
        f1.runAfterBoth(f2, new Runnable() {

            @Override
            public void run() {
                System.out.println("上面两个任务都执行完成了。");
            }
        });
    }

    //thenCompose 方法允许你对两个 CompletionStage 进行流水线操作，第一个操作完成时，将其结果作为参数传递给第二个操作。
    @Test
    public void thenCompose() throws Exception {
        CompletableFuture<Integer> f = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int t = new Random().nextInt(3);
                System.out.println("1"+Thread.currentThread());
                System.out.println("t1="+t);
                return t;
            }
        }).thenCompose(new Function<Integer, CompletionStage<Integer>>() {
            @Override
            public CompletionStage<Integer> apply(Integer param) {
                return CompletableFuture.supplyAsync(new Supplier<Integer>() {
                    @Override
                    public Integer get() {
                        int t = param *2;
                        System.out.println("2"+Thread.currentThread());
                        System.out.println("t2="+t);
                        return t;
                    }
                });
            }

        });
        System.out.println("3"+Thread.currentThread());
        System.out.println("thenCompose result : "+f.get());
    }

    @Test
    public void thenComposeAsync() throws Exception {
        CompletableFuture<Integer> f = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int t = new Random().nextInt(3);
                System.out.println("1"+Thread.currentThread());
                System.out.println("t1="+t);
                return t;
            }
        }).thenComposeAsync(new Function<Integer, CompletionStage<Integer>>() {
            @Override
            public CompletionStage<Integer> apply(Integer param) {
                return CompletableFuture.supplyAsync(new Supplier<Integer>() {
                    @Override
                    public Integer get() {
                        int t = param *2;
                        System.out.println("2"+Thread.currentThread());
                        System.out.println("t2="+t);
                        return t;
                    }
                });
            }

        });
        System.out.println("3"+Thread.currentThread());
        System.out.println("thenCompose result : "+f.get());
    }


    @Test
    public void allOf() {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                System.out.println("feature");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }
            System.out.println("run end ...");
        });
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            try {
                System.out.println("feature2");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }
            System.out.println("run end ...");
        });

        CompletableFuture<Void> future3 = CompletableFuture.runAsync(() -> {
            try {
                System.out.println("feature3");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }
            System.out.println("run end ...");
        });

        // 上面的示例是多个任务之间的调度，最后一个任务必须等之前的3个任务都完成后(allOf)，才能执行。
        // 如果前面3个任务只有一个完成最后一个任务就可以执行,那就用anyOf方法，把上面代码中allOf改成anyOf，其他代码不变，执行结果如下：
        CompletableFuture.allOf(future,future2,future3).thenAccept(
                r -> {
                    System.out.println("最后泡咖啡");
                }
        );
        System.out.println("我是主线程");

    }

}
