package cn.com.zv2.server;

import cn.com.zv2.model.Person;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lb
 * @description
 * @date 2020/5/18
 */
@WebService
public class PersonServer {

    private List<Person> personList = new ArrayList<>();

    public void add(Person person) {
        personList.add(person);
    }

    public List<Person> getAll() {
        return personList;
    }
}
