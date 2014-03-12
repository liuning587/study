package test.codeconvert;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CodeConverter;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.Loader;
import javassist.NotFoundException;
import javassist.Translator;

public class TranslateConvert {
	public static void main(String[] args) throws Throwable {

		ConverterTranslator xlat = new ConverterTranslator();
		ClassPool pool = ClassPool.getDefault();
		CodeConverter convert = new CodeConverter();
		CtMethod smeth = pool.get("test.codeconvert.Bean").getDeclaredMethod(
				"setA");
		CtMethod pmeth = pool.get("test.codeconvert.TranslateConvert")
				.getDeclaredMethod("reportSet");
		convert.insertBeforeMethod(smeth, pmeth);
		xlat.setConverter(convert);
		Loader loader = new Loader();
		loader.addTranslator(pool, xlat);

		// invoke "main" method of application class
		loader.run("test.codeconvert.BeanTest", new String[] {});

	}
	
	public static void reportSet(Bean target, String value) {
        System.out.println("Call to set value " + value);
    }
    
    public static class ConverterTranslator implements Translator
    {
        private CodeConverter m_converter;
        
        private void setConverter(CodeConverter convert) {
            m_converter = convert;
        }
        
        public void start(ClassPool pool) {}
        
        public void onLoad(ClassPool pool, String cname)
            throws NotFoundException, CannotCompileException {
            CtClass clas = pool.get(cname);
            clas.instrument(m_converter);
        }
    }
}
