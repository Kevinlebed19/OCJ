package com.kevin;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Objects;

class Zebra extends Animal implements Serializable  {

    private static final long serialVersionUID = -8139572278240224440L;
    final String name;
    transient final String lastName = "Zebulon";
    int stripeAmount;
    final char tier = 'A';


    public Zebra(String name, int stripeAmount) {

        if (name == null || name.isEmpty()) throw new IllegalArgumentException("name must not be null or empty");
        this.name = name;
        this.stripeAmount = stripeAmount;
    }

    public void revokeStripe(){
        stripeAmount--;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new Zebra("lameZebra", 0);
    }

    private Object readResolve() throws ObjectStreamException {
        return new Zebra(name, 10);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zebra zebra = (Zebra) o;
        return stripeAmount == zebra.stripeAmount && name.equals(zebra.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, stripeAmount);
    }

    @Override
    public String toString() {
        return "Zebra{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", stripeAmount=" + stripeAmount +
                '}';
    }
}
