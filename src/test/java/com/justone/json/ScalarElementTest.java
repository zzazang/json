/*
 * The MIT License
 *
 * Copyright 2016 JustOne Database Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.justone.json;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Pattern;
import junit.framework.TestCase;

/**
 *
 * @author Duncan
 */
public class ScalarElementTest extends TestCase {
  
  public ScalarElementTest(String testName) {
    super(testName);
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
  }
  
  @Override
  protected void tearDown() throws Exception {
    super.tearDown();
  }

  /**
   * Test of isScalar method, of class ScalarElement.
   */
  public void testType() {
    
    System.out.println("type");

    assertEquals(Element.NULL, new ScalarElement().type());
    assertEquals(Element.BOOLEAN, new ScalarElement(false).type());
    assertEquals(Element.NUMBER, new ScalarElement(1).type());
    assertEquals(Element.STRING, new ScalarElement("string").type());
    
  }//testType()
  
  /**
   * Test of isScalar method, of class ScalarElement.
   */
 public void testIsScalar() {
    
    System.out.println("isScalar");

    ScalarElement instance = new ScalarElement();
    assertEquals(true, instance.isScalar());
    
  }//testIsScalar()

  /**
   * Test of isObject method, of class ScalarElement.
   */
  public void testIsObject() {

    System.out.println("isObject");
    
    ScalarElement instance = new ScalarElement();
    assertEquals(false, instance.isObject());
    
}//testIsObject()

  /**
   * Test of isArray method, of class ScalarElement.
   */
  public void testIsArray() {
    
    System.out.println("isArray");
    
    ScalarElement instance = new ScalarElement();
    assertEquals(false, instance.isArray());
       
  }//testIsArray()

  /**
   * Test of toString method, of class ScalarElement.
   */
  public void testToString() {
    
    System.out.println("toString");
    
    ScalarElement instance = new ScalarElement();
    assertEquals("null", instance.toString());

    instance = new ScalarElement(false);
    assertEquals("false", instance.toString());
  
    instance = new ScalarElement(1);
    assertEquals("1", instance.toString());

    instance = new ScalarElement(1.0);
    assertEquals("1.0", instance.toString());

    instance = new ScalarElement("string");
    assertEquals("\"string\"", instance.toString());

    instance = new ScalarElement(Element.STRING,"string");
    assertEquals("\"string\"", instance.toString());
    
  }//testToString()

  /**
   * Test of size method, of class ScalarElement.
   */
  public void testSize() {
    
    System.out.println("size");
    
    ScalarElement instance = new ScalarElement();
    assertEquals(0, instance.size());

    instance = new ScalarElement(false);
    assertEquals(0, instance.size());

    instance = new ScalarElement(1);
    assertEquals(0, instance.size());
  
    instance = new ScalarElement(1.0);
    assertEquals(0, instance.size());
 
    instance = new ScalarElement("string");
    assertEquals(0, instance.size());

    instance = new ScalarElement(Element.STRING,"string");
    assertEquals(0, instance.size());
  
  }//testSize()

  /**
   * Test of hasKey method, of class ScalarElement.
   */
  public void testHasKey() {
    
    System.out.println("hasKey");
    
    ScalarElement instance = new ScalarElement();
    assertEquals(false, instance.hasKey("a"));

    instance = new ScalarElement(false);
    assertEquals(false, instance.hasKey("a"));

    instance = new ScalarElement(1);
    assertEquals(false, instance.hasKey("a"));
  
    instance = new ScalarElement(1.0);
    assertEquals(false, instance.hasKey("a"));

    instance = new ScalarElement("string");
    assertEquals(false, instance.hasKey("a"));
    
    instance = new ScalarElement(Element.STRING,"string");
    assertEquals(false, instance.hasKey("a"));
    
  }//testHasKey()

  
  /**
   * Test of hasIndex method, of class ScalarElement.
   */
  public void testHasIndex() {
    
    System.out.println("hasIndex");
    
    ScalarElement instance = new ScalarElement();
    assertEquals(false, instance.hasIndex(0));

    instance = new ScalarElement(false);
    assertEquals(false, instance.hasIndex(0));
 
    instance = new ScalarElement(1);
    assertEquals(false, instance.hasIndex(0));
  
    instance = new ScalarElement(1.0);
    assertEquals(false, instance.hasIndex(0));

    instance = new ScalarElement("string");
    assertEquals(false, instance.hasIndex(0));

    instance = new ScalarElement(Element.STRING,"string");
    assertEquals(false, instance.hasIndex(0));

  }//testHasIndex()

  /**
   * Test of hasPattern method, of class ScalarElement.
   */
  public void testHasPattern() {
    
    System.out.println("hasPattern");
    
    ScalarElement instance = new ScalarElement();
    assertEquals(false, instance.hasPattern(Pattern.compile("a")));

    instance = new ScalarElement(false);
    assertEquals(false, instance.hasPattern(Pattern.compile("a")));

    instance = new ScalarElement(1);
    assertEquals(false, instance.hasPattern(Pattern.compile("a")));
  
    instance = new ScalarElement(1.0);
    assertEquals(false, instance.hasPattern(Pattern.compile("a")));

    instance = new ScalarElement("string");
    assertEquals(false, instance.hasPattern(Pattern.compile("a")));
    
    instance = new ScalarElement(Element.STRING,"string");
    assertEquals(false, instance.hasPattern(Pattern.compile("a")));
    
  }//testHasPattern()  
      
  /**
   * Test of getChildElements method, of class ScalarElement.
   */
  public void testGetChildElements() {
    
    System.out.println("getChildElements");
    
    ScalarElement instance = new ScalarElement();
    Iterator<Element> iterator = instance.getChildElements();
    
    assertNull(instance.getChildElements());
    
  }//testGetChildElements()
 
  /**
   * Test of getDescendentElements method, of class ScalarElement.
   */
  public void testGetDescendentElements() {
    
    System.out.println("getDescendentElements");
    
    ScalarElement instance = new ScalarElement();
    LinkedList<Element> list=new LinkedList<>();
    list = instance.getDescendentElements("a",list);
    
    assertTrue(list.isEmpty());
    
  }//testGetDescendentElements()
   
  /**
   * Test of getScalarElements method, of class ScalarElement.
   */
  public void testGetScalarElements() {
    
    System.out.println("getScalarElements");
    
    ScalarElement instance = new ScalarElement();
    LinkedList<Element> list = instance.getScalarElements(new LinkedList<Element>());
    
    assertTrue(list.contains(instance));
    assertEquals(1,list.size());
    
  }//testGetDescendentElements()  
 
  /**
   * Test of getChildElement method, of class ScalarElement.
   */
  public void testGetChildElement_String() {
    
    System.out.println("getChildElement");
    
    ScalarElement instance = new ScalarElement();
    assertNull(instance.getChildElement("a"));

    instance = new ScalarElement(false);
    assertEquals(null, instance.getChildElement("a"));
 
    instance = new ScalarElement(1);
    assertEquals(null,instance.getChildElement("a"));
  
    instance = new ScalarElement(1.0);
    assertEquals(null,instance.getChildElement("a"));

    instance = new ScalarElement("string");
    assertEquals(null,instance.getChildElement("a"));
    
    instance = new ScalarElement(Element.STRING,"string");
    assertEquals(null,instance.getChildElement("a"));
    
  }//testGetChildElement_String()

  /**
   * Test of getChildElement method, of class ScalarElement.
   */
  public void testGetChildElement_Integer() {
    System.out.println("getChildElement");
    
    ScalarElement instance = new ScalarElement();
    assertNull(instance.getChildElement(0));
    
    instance = new ScalarElement(false);
    assertEquals(null, instance.getChildElement(0));
    
    instance = new ScalarElement(1);
    assertEquals(null, instance.getChildElement(0));

    instance = new ScalarElement(1.0);
    assertEquals(null, instance.getChildElement(0));
   
    instance = new ScalarElement("string");
    assertEquals(null, instance.getChildElement(0));
    
    instance = new ScalarElement(Element.STRING,"string");
    assertEquals(null, instance.getChildElement(0));    
    
    
  }//testGetChildElement_Integer()

  /**
   * Test of getChildElement method, of class ScalarElement.
   */
  public void testGetChildElement_Pattern() {
    
    System.out.println("getChildElement");
    
    ScalarElement instance = new ScalarElement();
    assertNull(instance.getChildElement(Pattern.compile("a")));

    instance = new ScalarElement(false);
    assertNull(instance.getChildElement(Pattern.compile("a")));
 
    instance = new ScalarElement(1);
    assertNull(instance.getChildElement(Pattern.compile("a")));
  
    instance = new ScalarElement(1.0);
    assertNull(instance.getChildElement(Pattern.compile("a")));

    instance = new ScalarElement("string");
    assertNull(instance.getChildElement(Pattern.compile("a")));
    
    instance = new ScalarElement(Element.STRING,"string");
    assertNull(instance.getChildElement(Pattern.compile("a")));
        
  }//testGetChildElement_Pattern()

}//ScalarElementTest{}
