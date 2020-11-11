# Java 3D Engine

This is a 3D rendering library. It is a modular library which can paint complex 3D shapes or  an environment onto a JPanel. It is made easy to use and flexible by using code reusability.  Making of a new shape is as simple as making a new class. There are two types of shapes, 
- Basic Shape 
These shapes are made from points and planes. These shapes do not contain any sub  shapes. 
- Composite Shape 
This type of shape has multiple shapes in it. For instance a house can be made by a  cuboid at the bottom and a pyramid at the top. 

## Packages
1. j3d.components 
2. j3d.core 
3. j3d.shapes 

### j3d.components 

This package contains all the components required in the environment to build the shape.  The component elements are Vector, Plane and Shape . The most basic element of the  environment is the Vector . In general context every point plotted is a Vector. It is used  by Plane to create Planes. A Plane is an ArrayList of vectors. The three parameters  required for defining a plane is Vector array,color and darkSide . darkSide is a vector  which is surrounded by planes. The other entity is Shape ,it is ArrayList of Planes, a  shape is made up of multiple plane. 

Each above element requires mathematical computation to get plotted, for instance, the  Vector object has three kind of instance variable first is general coordinate x,y,z .Then  there is transformed x,y,z represented as tx,ty,tz. Each vector is referenciated and  projected. So there is referenciated x,y,z and projected x and y. 

The other important concept related to plane is clipping. It’s is required when the case  arises as the planes which are to be drawn are behind the observer. For this condition  what is done that we check, each Vector of the plane, that whether it lies back side of   observer’s plane or front side. If it is front side we add it to a clippedPlane otherwise we  calculate the intersecting vector just in front of observer’s plane ,with respect to the  previous vector. And it to clipped plane. By using this methodology we create a clipped  plane which is visible to Observer. 
 Finally, we are plotting planes in paint method using fillPolygon method of graphics.

### J3d.core 
This package contains all the UI building classes. It contains classes like DrawPanel,  J3D,J3DView and J3DCore. The JPanel is extended in the DrawPanel class.The constructor of this classes sets the screenHeight and screenWidth of panel drawn. DrawPanel also sets the env(Shape) it  draw method is invoked. 

All the key events are used in J3D.java. It extends Jframe and implements AWTListeners  . In the main method of J3D java we can add shapes to the env. In the eventDispatched  overridden methods we are using key events. To move observer left,right,forward and  backward using J3DView object. J3DCore contains static utility functions like referentiatePoint and setSreenDimensions. J3DView implements the mouseMotionListener and creates the view of env using shapes  and planes. 

### J3d.shapes 

In this package the blueprints of all the shapes are prepared using simple shapes. The  most basic shape is Line , here we are creating Plane object with two vectors in array to  draw a line. This line can then be used by other shapes. 

The other simple Shape is cuboid it contains 6 planes so array of 6 plane is created. For  the 8 vertices of the cuboid we are creating a vector array of size 8. The constructor for  the Cuboid is coordinate of the point and the dx, dy, dz length in three axes and the color.  Using these parameters we create above vector and using those vectors we create planes  and then planes are painted.  

Now for cube we use cuboid and just take a point coordinate and length to draw it. Similarly robot3 is drawn using cubes.