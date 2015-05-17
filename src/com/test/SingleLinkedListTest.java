package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.data.structure.SingleLinkedList;

public class SingleLinkedListTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSingleLinkedList() {
				SingleLinkedList linkedList =new SingleLinkedList();
				linkedList.insertFirst(22);
				linkedList.insertFirst(44);
				linkedList.insertFirst(65);
				linkedList.insertFirst(45);
				linkedList.insertFirst(45);
				linkedList.insertFirst(34);
			System.out.println(linkedList.start);



	}

}

