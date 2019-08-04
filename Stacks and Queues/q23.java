import java.util.LinkedList;
import java.util.Queue;
import java.awt.List;
import java.util.Arrays;
import java.util.Date;

//an animal shelter operates on first in first out basis (use a queue!). People get the oldest animal
//and say whether they prefer a dog or a cat. Or you can dequeue the first item. 
//Make the methods enqueue, dequeueAny, dequeueDog, dequeueCat. You may use the Linked List
//data structure.

public class q23 {
	

	static class Animal {
		String type;
		Date dateArrived;
	}
	 
	static class Dog extends Animal {
		Dog() {
			super();
			type = "dog";
		}
	}
	 
	static class Cat extends Animal {
		Cat() {
			super();
			type = "cat";
		}
	}
	 
	static class AnimalShelter {
		Queue<Dog> dogs;
		Queue<Cat> cats;
	 
		public AnimalShelter() {
			// TODO Auto-generated constructor stub
			dogs = new LinkedList<Dog>();
			cats = new LinkedList<Cat>();
		}
	 
		public void enqueue(Animal animal) throws Exception {
			boolean isCat = animal.type.equals("cat");
			boolean isDog = animal.type.equals("dog");
			if ((!isCat) && (!isDog))
				throw new Exception("Unknow type of animal!");
			animal.dateArrived = new Date();
			if (isCat){
				if(animal instanceof Cat)
					cats.offer((Cat)animal);
			}
			if (isDog){
				if(animal instanceof Dog)
					dogs.offer((Dog)animal);
			}
				
		}
	 
		public Animal dequeueAny() throws Exception {
			boolean noCat = cats.isEmpty();
			boolean noDog = dogs.isEmpty();
			if (noCat && noDog)
				throw new Exception("There are no more animals!");
			if (noCat)
				return dogs.poll();
			else if (noDog)
				return cats.poll();
			else
				return cats.peek().dateArrived.compareTo(dogs.peek().dateArrived) < 0 ? cats.poll(): dogs.poll();
		}
	 
		public Cat dequeueCat() throws Exception {
			boolean noCat = cats.isEmpty();
			if (noCat)
				throw new Exception("There are no more cats!");
			return cats.poll();
		}
	 
		public Dog dequeueDog() throws Exception {
			boolean noDog = dogs.isEmpty();
			if (noDog)
				throw new Exception("There are no more dogs!");
			return dogs.poll();
		}
	}

	
public static void main(String[] args) throws Exception {
	AnimalShelter as=new AnimalShelter();
	Animal[] animalList = {
			new Dog(),new Cat(),new Dog(),new Cat(),new Dog(),new Cat(),
			new Dog(),new Cat(),new Dog(),new Cat()
	};
for(int i = 0; i < animalList.length; i++) {
	as.enqueue(animalList[i]);}

for(int i = 0; i < 2; i++)
	System.out.println(as.dequeueAny());
}

}


	

