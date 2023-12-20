import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationExample {
    @Override
    @MethodInfo(author = "Anita",comments = "Main method",date = "Dec 19",revision = 1)
    public String toString(){
        return "Overridden toString method";
    }

    @Deprecated
    @MethodInfo(comments = "deprecated method",date = "Nov 17")
    public static void oldMethod(){
        System.out.println("Old method");
    }
    public static void main(String[] args) {
        for (Method method:AnnotationExample.class.getMethods()){
            if (method.isAnnotationPresent(MethodInfo.class)){
                for (Annotation ann : method.getDeclaredAnnotations()){
                    System.out.println("Annotation in "+method+" : "+ann);
                }
                MethodInfo methodInfo = method.getAnnotation(MethodInfo.class);
                if (methodInfo.revision() == 1){
                    System.out.println("Method with revision no 1 = "+ method);
                }
            }

        }
    }
}
