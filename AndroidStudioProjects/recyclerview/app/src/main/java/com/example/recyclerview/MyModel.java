package com.example.recyclerview;

public class MyModel {
        String name = "";
        int age = 0;

        public MyModel(String name, int age) {
                this.name = name;
                this.age = age;

        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public int getAge() {
                return age;
        }

        public void setAge(int age) {
                this.age = age;
        }
}
