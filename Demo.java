public class Demo
{
  public static void main(String[] args) {

    /*
  Person first = new Person("Kim");
  Person second = new Person("Pat");

  System.out.println(first.knows(second));   // should print "false"

  first.meet(second);

  System.out.println(first.knows(second));   // should print "true"
  System.out.println(second.knows(first));   // should print "true"

  first.knows(first);                    // should throw a RuntimeException
  */

  Person first = new Person("Kim");
    Person second = new Person("Pat");
    first.post("Only Kim can read this");

    first.meet(second);
    second.post("Friends are awesome");
    first.post("I agree");

    first.listMessages();
    second.listMessages();
  }
}
