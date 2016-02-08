/**
 * 
 */
package org.study.java8.samples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jecharles
 * Program to sort a array of employess using compare methods
 *
 */
public class LambdaExpression {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		LambdaExpression exp = new LambdaExpression();
		
		List<Employee> empList = new ArrayList<Employee>(10);
		empList.add(new Employee(12, "jebastin", 21));
		empList.add(new Employee(1, "Raj", 25));
		empList.add(new Employee(1, "charles", 24));
		empList.add(new Employee(3, "justin", 12));
		empList.add(new Employee(13, "Rahul", 31));
		
		List<Employee> listOfEmployee = new ArrayList<>(empList);
		exp.sortById(listOfEmployee);
		System.out.println("Employee list sorted  by id alone");
		exp.printEmployees(listOfEmployee);
		
		List<Employee> listOfEmployeeToBeSort = new ArrayList<>(empList);
		exp.sortByIdAndAge(listOfEmployeeToBeSort);
		System.out.println("Employee list sorted  by id and age");
		exp.printEmployees(listOfEmployeeToBeSort);
				
	
	}
	
	/**
	 * print of employees
	 * @param empList
	 */
	public void printEmployees(List<Employee> empList) {
		if (empList != null) {
			for (Employee emp : empList) {
				System.out.println(emp);
			}
		}
	}
	/**
	 * lambda expression with one statement
	 * @param empList
	 */
	public void sortById(List<Employee> empList) {
		Collections.sort(empList, (Employee b1, Employee b2) -> (int) (b1.getId() - b2.getId()) );
	}
	
	/**
	 * Lambda expression with block
	 * @param empList
	 */
	public void sortByIdAndAge(List<Employee> empList) {
		Collections.sort(empList, (Employee b1, Employee b2) -> {
			
			int returnValue = 0;
			if (b1.getId() == b2.getId()) {
				returnValue =  (b1.getAge() - b2.getAge());
			} else {
				returnValue =   (b1.getId() - b2.getId());
			}

			return  returnValue;
		});
	}
	
	/**
	 * Just employee object
	 * @author jecharles
	 *
	 */
	public static class Employee {
		private int id;
		private String name;
		private int age;
		public Employee(int id, String name, int age) {
			this.id = id;
			this.name = name;
			this.age = age;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
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
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			StringBuilder builder = new StringBuilder("");
			builder.append(id).append(",").append(name).append(",").append(age);
			return builder.toString();
		}
	}

}
