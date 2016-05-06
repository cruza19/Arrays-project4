//Project 4 CST 112
//Abel Cruz  
String title = "Project Number 4";
String info=  "Press key with first letter of a function ('?' for help; 'q' to exit";
String author = "Abel Cruz";
int [] num = {100, 23, 7, 11, 344, 630, 42, 26, 90, 57, 10};
int numbers=  num.length;
Button[] buttons;
String buttonN[]={
"Big", "Small", "Add", "Minus", "Tripe", "Random"
};
int amoButtons= buttonN.length;
float horizon;
void setup() {
  size (600, 500);
  horizon=height-75;
   makebuttons();
}
void makebuttons() {
  buttons=  new Button[amoButtons];
  float x=10, y=horizon;
  for (int j=0; j<amoButtons; j++ ) {
    buttons[j]=  new Button( x, y, buttonN[j] );
    x += 100;
  }
}
void draw() {
  background( 255 );

  fill( 30, 90, 200);
 display(); 
buttons();
}


void display(){
  int space=20;

  float x=50, y=50;
  for (int j=0; j<numbers; j++) {
    text( num[j], x, y );
    y += space;
  }

  y += space;

  ////  display total and average
  int total=  sum( num, numbers );
  float avg=  float(total) / numbers;  
  text( "The sum is: "+total, 85, y );
  y += space;
  text( "The average is:  "+avg, 85, y );
  //// Title, etc..
  textSize(20);
  text( title, width/6, 20 );
  textSize(12);
  text( info, width/6, 40 );
  fill(90,47,150);
  text( "Keys:  b(big) , s(small) , a(add) , m(minus) , t(triple), r(random)", width/6, 55 );
  text( author, 20, height-20 );
}
void keyPressed() {
  if (key == 'q') exit();
  else if (key == 'b') big( num, numbers );
  else if (key == 's') small( num, numbers ); 
  else if (key == 'a') inc( num, numbers );
  else if (key == 'm') dec( num, numbers );
  else if (key == 't') triple( num, numbers );
  else if (key == 'r') randomize( num, numbers );
  else text( "NO SUCH FUNCTION:  "+key, width/2, height/2 );
}
int sum( int a[], int m ) {
  int result=0;
  for (int j=0; j<m; j+=1 ) {
    result += a[j];
  }
  return result;
}
void big( int a[], int m ) {
  // Move the biggest number to the end of the array. 
  // (Swap array elements, to keep all of the numbers.)
  int w=0;
  for (int j=1; j<m; j+= 1) {
    if (a[j] > a[w]) w=j;
  }
  int tmp;
  tmp=  a[m-1];              // Save last element of array.
  a[m-1]=  a[w];             // Store biggest at end.
  a[w]=  tmp;
}

void small( int a[], int m ) {
  // Move the smallest number to the beginning of the array 
  // (Swap, to keep all numbers.)
  int w=0;
  for (int j=1; j<m; j+=1) {
    if (a[j] < a[w]) w=j;
  }
  int tmp;
  tmp=  a[0];                // Save first element of array.
  a[0]=  a[w];               // Move selected element to the beginning.
  a[w]=  tmp;
}

void inc( int a[], int m ) {    //add
  // Increase each number by one.
  for (int j=0; j<m; j+=1) {
    a[j]+=1;
  }
}

void dec( int a[], int m ) {      //subtract
  // Decrease each number by one.
  for (int j=0; j<m; j+=1) {
    a[j]-=1;
  }
}

void triple( int a[], int m ) {  //3x
  // Triple each number.
  for (int j=0; j<m; j+=1) {
    a[j] *= 3;
  }
}
void randomize( int a[], int m ) {    //random
  // Replace all numbers woth random values.
  for (int j=0; j<m; j++) {
    a[j]=  int( random( 0, 1000 ) );
  }
}
void buttons() {
  for (int j=0; j<buttonN.length; j++) {
    buttons[j].show();
  }
}
class Button {
  float x, y;
  float w=80, h=30;
  String name;
  float r=167, g=30, b=30;

  Button( float x, float y, String s ) {
    this.x=x;
    this.y=y;
    this.name=  s;
  }

  void show() {
    stroke(0);
    fill(r, g, b);
    rect( x, y, w, h );
    fill(255,255,255);
    text( name, x+5, y+h*2/3 );
  }
  boolean click( float xx, float yy ) {
    if (xx < x)   return false;
    if (xx > x+w) return false;
    if (yy < y)   return false;
    if (yy > y+h) return false;
    return true;
  }
}
void mousePressed() {

  if ( buttons[0].click(mouseX, mouseY) ) { 
    big( num, numbers ); 
    return;
  }
  if ( buttons[1].click(mouseX, mouseY) ) { 
    small( num, numbers ); 
    return;
  }
  if ( buttons[2].click(mouseX, mouseY) ) { 
    inc( num, numbers );
    
    return;
  }
  if ( buttons[3].click(mouseX, mouseY) ) { 
    dec( num, numbers ); 
    return;
  }
  if ( buttons[4].click(mouseX, mouseY) ) { 
    triple( num, numbers ); 
    return;
  }
  if ( buttons[5].click(mouseX, mouseY) ) { 
    randomize( num, numbers ); 
    return;
  }
}



