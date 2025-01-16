package com.antonioProjeto;
import java.util.Random;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class Main {
    public static void main(String[] args) {
        Random gerador = new Random();
        for(int i = 1; i<101;i++) {
            int qtdNos = gerador.nextInt(10000, 1000000);
            DescriptiveStatistics stats = new DescriptiveStatistics();
            for(int x = 0; x<100; x++) {
                ArvBinBusca<Integer, Integer> arvore = new ArvBinBusca<>();
                for (int j = 0; j < qtdNos; j++) {
                    boolean b;
                    do {
                        int noRandom = gerador.nextInt(1000000);
                        b = arvore.put(noRandom, noRandom);
                    } while (!b);
                }
                stats.addValue(arvore.altura());
            }
            System.out.println("Árvore " + i + ": Quantidade de nós - "+ qtdNos + " Altura esperada - " + (int)(Math.log(qtdNos) * 1.39) +" Média das alturas - "+ stats.getMean() + " Desvio padrão: " + stats.getStandardDeviation());
        }
    }
}