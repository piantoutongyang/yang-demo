package com.mingyisoft.javademo.io.serializable;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class ExternalizableDemo1 {
	public static void main(String[] args) {
		try {

			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("xxx.aaa"));
			Car c1 = new Car("alex", 12);
			Car c2 = new Car("jack", 15);

			oos.writeObject(c1);
			oos.writeObject(c2);

			oos.flush();
			oos.close();

			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("xxx.aaa"));

			Car c11 = (Car) ois.readObject();
			Car c22 = (Car) ois.readObject();

			System.out.println(c11);
			System.out.println(c22);

			ois.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Car implements Externalizable {
	private String name;
	private Integer age;

	public Car() {

	}

	public Car(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return this.name + this.age;
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(new StringBuffer(name).reverse());
		out.writeInt(age);
	}

	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		this.name = (((StringBuffer) in.readObject()).reverse()).toString();
		this.age = in.readInt();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
