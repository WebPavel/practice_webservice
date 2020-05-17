package cn.com.zv2.client;

import cn.com.zv2.stub.person.Person;
import cn.com.zv2.stub.person.PersonServer;
import cn.com.zv2.stub.person.PersonServerService;

import java.util.List;

/**
 * @author lb
 * @description
 * @date 2020/5/18
 */
public class PersonClient {

    private PersonServer personServer = new PersonServerService().getPersonServerPort();

    public void add(Person person) {
        personServer.add(person);
    }

    public List<Person> getAll() {
        return personServer.getAll();
    }

    public static void main(String[] args) {
        PersonClient client = new PersonClient();

        Person person = new Person();
        person.setId(9000);
        person.setName("LiTao");
        person.setAge(23);
        person.setAddress("beijing");

        Person xing = new Person();
        xing.setId(9001);
        xing.setName("xing");
        xing.setAge(24);
        xing.setAddress("shanghai");

        client.add(person);
        client.add(xing);

        List<Person> personList = client.getAll();
        personList.forEach(System.out::println);
    }
}
