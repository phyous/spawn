package org.phyous.spawn;

import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: pyoussef
 * Date: 7/21/12
 * Time: 10:56 AM
 * To change this template use File | Settings | File Templates.
 */

public class SpawnTest extends TestCase {
    class TestObjectBasic{
        String a;int b;
        public TestObjectBasic(String a, int b){this.a = a; this.b = b;}
        public String a(){return a;}
        public int b(){return b;}
    }

    class TestObjectComposite{
        Short s;TestObjectBasic o;
        public TestObjectComposite(Short s, TestObjectBasic o){this.s = s; this.o = o;}
        public Short s(){return s;}
        public TestObjectBasic o(){return o;}
    }

    class TestObjectNested{
        String a;int b;TestObjectNested o;
        public TestObjectNested(String a, int b, TestObjectNested o){this.a = a; this.b = b; this.o = o;}
        public String a(){return a;}
        public int b(){return b;}
        public TestObjectNested o(){return o;}
    }

    class TestObjectNoParamConstructor{
        public TestObjectNoParamConstructor(){};
    }

    public void testBasicObject() throws Exception{
        TestObjectBasic to = Spawn.createObject(TestObjectBasic.class);
        assertEquals(to.a().getClass(), String.class);
        assertEquals(((Object)to.b()).getClass(), Integer.class);
        System.out.println(to.a());
        System.out.println(to.b());
    }

    public void testCompositeObject(){
        TestObjectComposite to = Spawn.createObject(TestObjectComposite.class);
        assertEquals(to.s().getClass(), Short.class);
        TestObjectBasic tb = to.o();
        assertEquals(tb.getClass(), TestObjectBasic.class);
        assertEquals(tb.a().getClass(), String.class);
        assertEquals(((Object)tb.b()).getClass(), Integer.class);
    }

    // test an object with a nested constructor
    // That is, the Object has constructor parameter that is of the same type)
    public void testNestedObject() throws Exception{
        TestObjectNested to = Spawn.createObject(TestObjectNested.class);
        assertEquals(to.a().getClass(), String.class);
        assertEquals(((Object)to.b()).getClass(), Integer.class);
        // Will return null for nested object constructors
        assertEquals(to.o(), null);
    }

    public void testObjectEmptyConstructor() throws Exception{
        TestObjectNoParamConstructor to = Spawn.createObject(TestObjectNoParamConstructor.class);
        assertTrue(to != null);
    }
}
