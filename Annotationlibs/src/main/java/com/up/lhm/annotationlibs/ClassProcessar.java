package com.up.lhm.annotationlibs;

import com.google.auto.service.AutoService;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic.Kind;

/**
 * @author lianghaimiao
 * @date 2019/5/11
 * @function 编译时注解处理器
 */
@AutoService(value = Processor.class)
public class ClassProcessar extends AbstractProcessor {

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
    }
    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        Messager messager = processingEnv.getMessager();
        for (Element element :roundEnvironment.getElementsAnnotatedWith(BindVieww.class)) {
            if (element.getKind()==ElementKind.FIELD){
                Name simpleName = element.getSimpleName();
                String s = simpleName.toString();
                String simpleName1 = element.getClass().getSimpleName();
                messager.printMessage(Kind.NOTE,"printMessaege:"+element.toString()+";"+simpleName1+s+";"+element
                        .getClass().toString());
            }
        }
        return true;
    }


    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> annotation =new HashSet<>();
        annotation.add("com.up.lhm.annotationlibs.BindVieww");
        return annotation;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }
}
