package services;

import io.ReadAndWriteHuman;
import models.Human;

import java.util.ArrayList;
import java.util.List;

public class HumanService {
    private List<Human> humans = new ArrayList<>();

    public HumanService(){
        humans = ReadAndWriteHuman.readHuman();
    }

    public void save(Human human) {
        humans.add(human);
        ReadAndWriteHuman.writeHuman(humans);
    }

    public List<Human> findAll() {
        return humans;
    }

    public void delete(int index) {
        humans.remove(index);
    }

    public void edit(int index, Human human) {
        humans.set(index, human);
        ReadAndWriteHuman.writeHuman(humans);
    }

    public int findIndexByName(String name){
        for (int i = 0; i < humans.size(); i++) {
            if (humans.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }
}

