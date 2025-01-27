package com.mycompany.calculadora;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Calculus {

    public double xSuma(double a, double b) {
        BigDecimal c = new BigDecimal(String.valueOf(a));
        BigDecimal d = new BigDecimal(String.valueOf(b));

        BigDecimal suma = c.add(d); 
        return suma.doubleValue();
    }

    public double xResta(double a, double b) {
        BigDecimal c = new BigDecimal(String.valueOf(a));
        BigDecimal d = new BigDecimal(String.valueOf(b));

        BigDecimal resta = c.subtract(d); 
        return resta.doubleValue();
    }

    public double xMulti(double a, double b) {
        return a * b;
    }

    public double xDiv(double a, double b) {
        return Math.round((a / b) * 100.0) / 100.0;
    }

    public double xExp(double a, double b) {
        //return Math.pow(a, b);
        // Manejar casos especiales
        if (b == 0) {
            return 1;
        }
        if (b == 1.0) {
            return a;
        } else if (b % 1 != 0) {
            return xRaiz(b, a);
        }
        if (b < 0) {
            return 1 / xExp(a, -b); 
        }
        double c = a;
        for (int i = 0; i < b - 1; i++) {
            c = c * a;
        }

        return c;
    }

    public double xRaiz(double b, double a) {//a(b = 1/2) == e(b*ln(a))
        System.out.println("entre");
        if (a < 0 && b % 2 == 0) {
            throw new IllegalArgumentException("No se pueden calcular raíces pares de números negativos.");
        }
        if (b == 0) {
            throw new IllegalArgumentException("La raíz 0 no está definida.");
        }
        if (a == 0) {
            return 0; // La raíz de 0 es siempre 0.
        }
        if (b % 1 != 0) {
            System.out.println("a"+ a);
            System.out.println("b"+ b);
            System.out.println("(1 / b) * xLn(a)"+ (1 / b) * xLn(a));
            System.out.println("xLn"+ xLn(a));
            double resu = ( b) * xLn(a);
            return Math.pow(Math.E, resu);
        }
        double precision = 0.000001;
        double limiteInferior = 0;
        double limiteSuperior = a;
        double medio = 0;

        // Búsqueda iterativa para encontrar la raíz
        while (Math.abs(limiteSuperior - limiteInferior) > precision) {
            medio = (limiteSuperior + limiteInferior) / 2;
            double potencia = Math.pow(medio, b); // Calculamos medio^b

          
            if (potencia > a) {
                limiteSuperior = medio; 
            } else {
                limiteInferior = medio;
            }
        }

        return Math.round(medio * 100) /100;

    }

  
    public double xPorcentaje(double a, double b) {
        return (a * b) / 100;
    }

    public double xLog(double a) {
        double log = 10;
        double ñ, aux = 0;
        int entero = 1, aux2, aux3 = 0;
        do {
            aux2 = (int) Math.pow(log, entero);// alternativamente puedo usar el metodo xExp()
            if (aux2 <= (int) a) {
                aux3 = entero;
                entero++;
            }
        } while (aux2 < (int) a);
        if (Math.pow(log, aux3) == a) {
            return aux3;
        } else {
            double i = 0;
            do {
                ñ = Math.pow(log, (aux3 + i / 100000));
                if (ñ < a) {
                    aux = (aux3 + i / 100000);
                    i++;
                }
            } while (ñ < a);
        }
        return aux;

    }

    public double xLn(double a) {
        double e = Math.E;
        double ñ, aux = 0, aux2;
        int entero = 1, aux3 = 0;
        do {
            aux2 = Math.pow(e, entero);// alternativamente puedo usar el metodo xExp()
            System.out.println(aux2);
            if (aux2 <= a) {
                aux3 = entero;
                entero++;
            }
        } while (aux2 < (int) a);
        if (Math.pow(e, aux3) == a) {
            return aux3;
        } else {
            double i = 0;
            do {
                ñ = Math.pow(e, (aux3 + i / 100000));
                if (ñ < a) {
                    aux = (aux3 + i / 100000);
                    i++;
                }
            } while (ñ < a);
        }
        return aux;
    }
}
