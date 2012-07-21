Spawn - A random object creator for java
=====

While testing, its sometimes useful to be able to create objects without worrying about passing constructor parameters.
Spawn tries to simplify the object creation process through constructor reflection and random input generation.

Ex:
```java
import org.phyous.spawn;
class SimpleObject{
    String a;int b;
    public SimpleObject(String a, int b){this.a = a; this.b = b;}
    public String a(){return a;}
    public int b(){return b;}
}

SimpleObject o = Spawn.createObject(SimpleObject.class); // <-- abracadabra

// object 'o' now refers to a randomly generated SimpleObject
System.out.println(to.a());
System.out.println(to.b());
```

Output:
```plain
430d9f2e-dc6b-4995-ac20-c54c95adf1eb
936094992
```

As you can see, the object created will have random data of the appropriate type passed to the constructor.
This allows for quick object creation and opens up interesting possibilities for fuzz testing(http://en.wikipedia.org/wiki/Fuzz_testing)

Notes:
* This doesn't work in cases where objects do validation on values passed to the constructor (as all values are randomly generated)
* If spawn fails to guess a way to construct the object, it returns null.

