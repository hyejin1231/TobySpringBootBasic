package tobyspring.config;

import java.util.stream.StreamSupport;

import org.springframework.boot.context.annotation.ImportCandidates;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyAutoConfigImportSelector implements DeferredImportSelector
{
	
	private final ClassLoader classLoader;
	
	public MyAutoConfigImportSelector(ClassLoader classLoader)
	{
		this.classLoader = classLoader;
	}
	
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata)
	{
//		return new String[]{
//				"tobyspring.config.autoconfig.DispatcherServletConfig",
//				"tobyspring.config.autoconfig.TomcatWebServerConfig"
//		};
		
		ImportCandidates candidates = ImportCandidates.load(MyAutoConfiguration.class, classLoader);
		
		return StreamSupport.stream(candidates.spliterator(), false).toArray(String[]::new);
	}
}
