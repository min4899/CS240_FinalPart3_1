import java.util.Iterator;
/*************************************************************************
  Winter 2017 CS 240 Programming Exam : Person

 Author: Minwoo Soh

 Dependencies: Stack, Queue, Dictionary

 Description:  Models a person, a list of messages that they can
               read, and a list of their friends, so that when you
               post a message, all your friends can read it too.

**************************************************************************/

public class Person {
    private String name;
    private SortedLinkedDictionary friends; // Store frinds
    private LinkedData<String> messages; // Stack to Store messages
    private SingleLinkedData queue;
    private int friendAmount;

    // Create a new Person with this name.
    public Person(String name) {
      this.name = name;
      friends = new SortedLinkedDictionary();
      messages = new LinkedData<String>();
      queue = new SingleLinkedData();
      friendAmount = 0;
    }

    // Make these two people become friends with each other.
    // Throw an exception if you try to meet yourself.
    // We are allowed to assume we didn't meet this person yet.
    public void meet(Person otherPerson) {
      if(name == otherPerson.getName())
      {
        throw new RuntimeException("You can't be your own friend.");
      }
      else
      {
        friends.add(otherPerson.getName(), otherPerson);
        if(!otherPerson.knows(this))
        {
          otherPerson.meet(this);
        }
      }
    }

    // Are these two people friends?
    // Throw an exception if you ask about knowing yourself.
    public boolean knows(Person otherPerson) {
      boolean result = false;
      if(name == otherPerson.getName())
      {
        throw new RuntimeException("You can't be your own friend.");
      }
      else
      {
        result = friends.contains(otherPerson.getName());
      }
      return result;
    }

    // Post a message to my list and the lists of all my friends
    public void post(String message) {
      messages.push(message);

      Iterator<Person> friendsList = friends.getValueIterator();
      while(friendsList.hasNext())
      {
        tempFriend = friendsList.next();
        if(tempFriend.knows(this))
        {
          
        }
      }
    }

    // Print a header, then all messages this Person can read, newest first
    public void listMessages() {
      System.out.println("== The wall of " + name + " ==");
      LinkedData<String> temp = new LinkedData<String>();
      while(!messages.isEmpty())
      {
        String tempMessage = messages.pop();
        System.out.println(tempMessage);
        temp.push(tempMessage);
      }
      while(!temp.isEmpty())
      {
        messages.push(temp.pop());
      }

      Iterator<String> friendName = friends.getKeyIterator();
      Iterator<Person> friendsObj = friends.getValueIterator();
      while(friendName.hasNext())
      {
        System.out.println("== The wall of " + friendName.next() + " ==");
        LinkedData<String> temp2 = new LinkedData<String>();
        LinkedData<String> friendsMessages = friendsObj.next().getMessages();
        while(!messages.isEmpty())
        {
          String tempMessage = friendsMessages.pop();
          System.out.println(tempMessage);
          temp.push(tempMessage);
        }
        while(!temp.isEmpty())
        {
          friendsMessages.push(temp.pop());
        }
      }
    }

    public String getName()
    {
      return name;
    }

    public SingleLinkedData getMessages()
    {
      SingleLinkedData<String> temp = messages;
      return temp;
    }
}

/*
SingleLinkedData<String> temp = new SingleLinkedData<String>();
LinkedData<String> temp2 = new LinkedData<String>();
while(!messages.isEmpty())
{
  String tempMessage = friendsMessages.pop();
  temp.enqueue(tempMessage);
  temp2.push(tempMessage);
}
while(!temp2.isEmpty())
{
  messages.push(temp.pop());
}
return temp;
*/
