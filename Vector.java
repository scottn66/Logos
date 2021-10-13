package alpha;

public class Vector {
	//Vector as a scalar of Unit Point i,j
	public Point u,s,v;
	public double magnitude;
	public float theta;
	
	Vector(double a, double b) {
		//[ax, by]
		//u is basis vector
		//s is the scalar variables
		//v is the vector product/point of the unit and scalar vectors
		Point u = new Point(1, 1);
		Point s = new Point(a, b);
		Point v = new Point(u.x*s.x, u.y*s.y);
	}
	
	public Point getu() {
		/*
		 * Def. basis: The 'basis' of a vector space is a set of linearly independent vectors that span the full space.
		 * 
		 * Linear dependence: u = av + bw;
		 * 						for all values of a and b
		 * 		one of the vectors can be expressed as a linear combination of the others, since it is already in the span of the others. 
		 * 
		 * Linearly independent: u!= av + bw; 
		 * 						for all values of a and b
		 */
		return u;
	}
	public Point gets() {
		return s;
	}
	public Point getv() {
		return v;
	}
	public double getMagnitude(Vector v) {
		// magnitude = sqrt(x*x + y*y);
		this.magnitude = Math.sqrt(v.v.x*v.v.x + v.v.y*v.v.y);
		return this.magnitude;
	}
	public float getTheta(Vector v) {
		/*
		 * Complex numbers: line segment along one axis, multiplied by -1 rotates it 180*, so therefore, multiplying it by sqrt(-1) yields a 90* rotation.
		 * i as operator for 90 degree rotation of a line segment.
		 * 
		 * written as:
		 * z = Re(z) + i[Im(z)];
		 * 
		 * ~->A = Axi + Ayj;
		 * 
		 * On the unit circle:
		 * z = cos(theta) + i*sin(theta)
		 * 
		 * real part as x-component and imaginary as y-component
		 * abs(z) = sqrt( [Re(z)]^2  +  i[Im(z)]^2 );
		 * theta = arctan[Im(z)/Re(z)]
		 * 
		 * Complex conjugate: 
		 * if ( z =  Re(z) + i[Im(z)] )
		 * 		z* = Re(z) - i[Im(z)];
		 * 		magnitude = sqrt( z*z ) //i.e. sqrt *(z*)
		 * 
		 * Re(z) = abs( z ) * Math.cos(theta)
		 * Im(z) = abs( z ) * Math.sin(theta)
		 * 
		 * Polar form: Complex number = Magnitude \_ theta
		 * note clockwise or anticlockwise: theta, theta + 180*
		 * 
		 * Unit circle cont.
		 * "phasors" = vectors whose tips rotate around the unit circle in the complex plane.
		 * as theta increases, phasor rotates anticlockwise maintaining a magnitude of 1 unit
		 * one period = phasor's return to original position
		 * as phasor rotates, projection of phasor onto axis traces out a sine wave on imaginary axis as theta increases
		 * 	and a cosine wave as theta increases along the real axis
		 */
		this.theta = (float)Math.atan(v.v.y/v.v.x);
		return theta;
	}
	
	
	public void setu(double i, double j) {
		//transformation
		u.x = i;
		u.y = j;
	}
	public void sets(double a, double b) {
		s.x = a;
		s.y = b;
	}
	public void setv(double ia, double jb) {
		v.x = ia;
		v.y = jb;
		double scalarA = ia/u.x;
		double scalarB = jb/u.y;
		sets(scalarA, scalarB);
	}
	
	public Vector linearCombination(Vector v, Vector w) {
		/*
		 * Linear combination: (of ->v & ->w)
		 * ai + bj
		 * where a,b are scalars of units i,j
		 * 
		 * if one scalar is fixed, the other varied, the tip of r draws a straight line. 
		 * both varying can result in either all possible points on plain, or are linearly dependent. Unless both 0
		 * "span" is the set of all reachable Vectors(points) with linear combination of a given pair of vectors. boolean linearlyDependent()
		 */
		double rx = v.v.x + w.v.x;
		double ry = v.v.y + w.v.y;
		Vector r = new Vector(rx,ry); //i.e. vector v is a point, via Point p.add, added to w, thereby combining into a new vector from basis vector i,j
		return r;
	}
	
	public Vector combine(Vector w) {
		// linear combination to vector 'in hand'
		double rx = this.v.x + w.v.x;
		double ry = this.v.y + w.v.y;
		Vector r = new Vector(rx,ry); //i.e. vector v is a point, via Point p.add, added to w, thereby combining into a new vector from basis vector i,j
		return r;
	}
	
	public Vector Combine(Vector w, Vector...rest) {
		// linear combination of multiple dimensions 3+
		double rx, ry;
		rx = w.v.x;
		ry = w.v.y;
		for (Vector V: rest) {
			rx += V.v.x;
			ry += V.v.y;
		}
		Vector r = new Vector(rx,ry); //i.e. vector v is a point, via Point p.add, added to w, thereby combining into a new vector from basis vector i,j
		return r;
	}
	
}
