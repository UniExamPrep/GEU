// Create a base class called CAL_AREA(Abstract). Use this
// class to store float type values that could be used to
// compute the volume of figures. Derive two specific
// classes called cone, hemisphere and cylinder from the
// base CAL_AREA. Add to the base class, a member function
// getdata ( ) to initialize base class data members and
// another member function display volume( ) to compute
// and display the volume of figures. Make display volume ( )
// as a pure virtual function and redefine this function in the
// derived classes to suit their requirements.
// Using these three classes, design a program that will
// accept dimensions of a cone, cylinder and hemisphere
// interactively and display the volumes. Remember values
// given as input will be and used as follows:
// Volume of cone = 1/3 πr2h
// Volume of hemisphere = 2/3 πr3
// Volume of cylinder = πr2h

#include <iostream>
#include <cmath>
using namespace std;

class Cal_Volume {
public:
    float r, h;
    void get_data(float radius, float height) {
        r = radius;
        h = height;
    }
    virtual void display_volume() = 0; // Pure virtual function
};

class Cone : public Cal_Volume {
public:
    void display_volume() override {
        cout << "Volume of cone is: " << (1.0 / 3.0) * M_PI * r * r * h << endl;
    }
};

class Hemisphere : public Cal_Volume { // Corrected base class to Cal_Volume
public:
    void display_volume() override {
        cout << "Volume of hemisphere is: " << (2.0 / 3.0) * M_PI * r * r * r << endl;
    }
};

class Cylinder : public Cal_Volume {
public:
    void display_volume() override {
        cout << "Volume of cylinder is: " << M_PI * r * r * h << endl;
    }
};

int main() {
    Cone C;
    Hemisphere H;
    Cylinder Cy;
    int op;
    float rad, ht;

    while (true) {
        cout << "\nChoose: \n\t1. Volume of Cone\n\t2. Volume of Hemisphere\n\t3. Volume of Cylinder\n\t4. Exit \nEnter: ";
        cin >> op;

        switch (op) {
        case 1:
            cout << "Enter radius and height of cone: ";
            cin >> rad >> ht;
            C.get_data(rad, ht);
            C.display_volume();
            break;
        case 2:
            cout << "Enter radius of hemisphere: ";
            cin >> rad;
            H.get_data(rad, 0.0);
            H.display_volume();
            break;
        case 3:
            cout << "Enter radius and height of cylinder: ";
            cin >> rad >> ht;
            Cy.get_data(rad, ht);
            Cy.display_volume();
            break;
        case 4:
            cout << "\nExiting...\n";
            return 0;
        default:
            cout << "\nInvalid option!\n";
        }
    }

    return 0;
}