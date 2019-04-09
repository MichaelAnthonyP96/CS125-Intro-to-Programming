//UIUC CS125 SPRING 2017 MP. File: Person.java, CS125 Project: Challenge6-RecursionSee, Version: 2017-04-04T10:07:11-0500.143642000
/**
 * @author mapope2
 *
 */
public class Person
{
private final String name;
private final int age;
private final char gender;
private final Person child1; //left child
private final Person child2; //right child

public Person(String name, int age, char gender, Person c1, Person c2)
{
    this.name=name;
    this.age=age;
    this.gender=gender;
    this.child1 = c1;
    this.child2 = c2;
}

public String toString()
{
    return name+"*"+age+"*"+gender;
}

public String getName() 
{
	return name;
}

public int getAge() 
{
	return age;
}

public char getGender() 
{
	return gender;
}

public boolean equals(Person p)
{
	return (this.name.equals(p.name)) &&
			(this.age==p.age) &&
			(this.gender==p.gender);
}


public void print() 
{
   System.out.println(this);
   if(child1 != null)
       child1.print();
   if(child2 != null)
       child2.print();
   
}

public int count() // total person count including this object
{
	if ((child1 == null) && (child2 == null))
		return 1;
	else if (child1 == null)
		return 1 + child2.count();
	else if (child2 == null)
		return 1 + child1.count();
	else
		return 1 + child1.count() + child2.count();
}
public int countGrandChildren() // but not greatGrandChildren
{
	return grandchildren(3);
}

public int grandchildren(int generation) {
	int count;
	if (generation == 1)
		count = 1;
	else 
		count = 0;
	if (child1 != null)
		count += child1.grandchildren(generation - 1);
	if (child2 != null)
		count += child2.grandchildren(generation -1);
	return count;
}

public int countMaxGenerations()
{
	if ((child1 == null) && (child2 == null))
		return 1;
	if (child1 == null)
		return 1 + child2.countMaxGenerations();
	if (child2 == null)
		return 1 + child1.countMaxGenerations();
	else {
		if (child2.countMaxGenerations() > child1.countMaxGenerations())
			return 1 + child2.countMaxGenerations();
		else 
			return 1 + child1.countMaxGenerations();
	}
}

public int countGender(char gen)
{
	if ((child1 == null) && (child2==null)) {
		if (this.gender == gen)
			return 1;
		else
			return 0;
	}
	else if (child1 == null) {
		if (this.gender == gen)
			return 1 + child2.countGender(gen);
		else
			return child2.countGender(gen);
	}
	else if (child2 == null) {
		if (this.gender == gen)
			return 1 + child1.countGender(gen);
		else 
			return child1.countGender(gen);
	}
	else  {
		if (this.gender == gen)
			return 1 + child1.countGender(gen) + child2.countGender(gen);
		else
			return child1.countGender(gen) + child2.countGender(gen);
	}
}


public Person search(String name, int maxGeneration)
{
	if (maxGeneration < 0)
		return null;
	if (this.name.equals(name))
		return this;
	Person left = null;
	Person right = null;
	if (child1 != null)
		left = child1.search(name, maxGeneration-1);
	if (child2 != null)
		right = child2.search(name, maxGeneration -1);
	if (right != null)
		return right;
	if (left!= null)
		return left;
	else
		return null;
		
}

} // end of class
