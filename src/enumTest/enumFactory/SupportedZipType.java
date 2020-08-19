package enumTest.enumFactory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.concurrent.LazyInitializer;

@Getter
@AllArgsConstructor
public enum  SupportedZipType {

    RAR("rar", new LazyInitializer<UnzipService>() {
        @Override
        protected UnzipService initialize() {
            return new RarUnzipServiceImpl();
        }
    }),

    ZIP("zip", new LazyInitializer<UnzipService>() {
        @Override
        protected UnzipService initialize() {
            return new ZipUnzipServiceImpl();
        }
    }),

    SEVEN_Z("7z", new LazyInitializer<UnzipService>() {
        @Override
        protected UnzipService initialize() {
            return new SevenZUnzipServiceImpl();
        }
    });

    private final String type;

    private final LazyInitializer<UnzipService> unzipService;
}
