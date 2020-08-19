package enumTest.enumFactory;

import org.apache.commons.lang3.concurrent.ConcurrentException;

import java.io.File;
import java.io.FileInputStream;

public class UnzipFactory {


    public UnzipService produce(File file) {
        try {
            return identifyFileType(file).getUnzipService().get();
        } catch (ConcurrentException e) {
            System.out.println(e);
        }
        return null;
    }


    private static SupportedZipType identifyFileType(File file) {
        SupportedZipType type = getFileType(file);
        if (type == null) {
          return null;
        }
        return type;
    }

    private static SupportedZipType getFileType(File file) {
        SupportedZipType res = null;
        try (FileInputStream inputStream = new FileInputStream(file)) {
            byte[] head = new byte[4];
            if (-1 == inputStream.read(head)) {
                return res;
            }
            int headHex = 0;
            for (byte b : head) {
                headHex <<= 8;
                headHex |= b;
            }
            switch (headHex) {
                case 0x504B0304:
                    res = SupportedZipType.ZIP;
                    break;
//                case 0x776f7264:
//                    return FileType.TAR;
                case -0x51:
                    res = SupportedZipType.SEVEN_Z;
                    break;
//                case 0x425a6839:
//                    return FileType.BZ2;
//                case -0x74f7f8:
//                    return FileType.GZ;
                case 0x52617221:
                    res = SupportedZipType.RAR;
                    break;
                default:
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

}
