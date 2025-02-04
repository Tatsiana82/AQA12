package priority;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
//Task1
@RunWith(Suite.class)
@Suite.SuiteClasses({
        Priority1.g.class,
        Priority1.f.class,
        Priority1.e.class,
        Priority1.d.class,
        Priority1.c.class,
        Priority1.b.class,
        Priority1.a.class
})
public class Priority1 {

    public static class g { @Test public void g() {assertTrue(true);} }
    public static class f { @Test public void f() {assertTrue(true);} }
    public static class e { @Test public void e() {assertTrue(true);} }
    public static class d { @Test public void d() {assertTrue(true);} }
    public static class c { @Test public void c() {assertTrue(true);} }
    public static class b { @Test public void b() {assertTrue(true);} }
    public static class a { @Test public void a() {assertTrue(true);} }
}