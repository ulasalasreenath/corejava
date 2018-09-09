package com.hackerearth.accolite;

class ABC1
{ 
    public int i = 0;

    public ABC1(String text) /* Line 4 */
    {
        i = 1; 
    }

    public ABC1() {

    }
} 

class XYZ extends ABC1
{
    public XYZ(String text)
    {
        i = 2; 
    } 

    public static void main(String args[])
    {
        XYZ sub = new XYZ("Hi"); 
        System.out.println(sub.i); 
    } 
}
