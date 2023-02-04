package jisuspring.config;

import org.springframework.boot.context.annotation.ImportCandidates;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.StreamSupport;


public class MyAutoConfigImportSelector implements DeferredImportSelector {
    private final ClassLoader classLoader;

    public MyAutoConfigImportSelector(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
//        Iterable<String> candidates = ImportCandidates.load(MyAutoConfiguration.class, classLoader);
//        return StreamSupport.stream(candidates.spliterator(), false).toArray(String[]::new);
        List<String> autoConfigs = new ArrayList<>();

//        for (String candidates : ImportCandidates.load(MyAutoConfiguration.class, classLoader)) {
//                autoConfigs.add(candidates);
//        }

        ImportCandidates.load(MyAutoConfiguration.class, classLoader).forEach(autoConfigs::add);

        // 컬렉션 객체를 toArray 에서 배열을 넣으면 배열 값이 넉넉하면 그대로 복사하고 작으면 무시하고 복제한다.
        return autoConfigs.toArray(new String[0]);

//        return autoConfigs.toArray(String[]::new);

//        return Arrays.copyOf(autoConfigs.toArray(), autoConfigs.size(), String[].class);
    }
}
