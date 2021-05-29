package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] a = new int[] {9,8,6,3,2,2,1,7,2,3,1};
        mergeSort(a);

        for (int i: a) {
            System.out.println(i);
        }
    }

    public static void mergeSort (int[] a) {
        mergeSort(a,0,a.length-1);
    }

    public static void mergeSort (int[] a,int i, int j) {
        if (i>=j) return;

        int mid = (j-i)/2 + i;

        mergeSort(a,i,mid);
        mergeSort(a,mid+1,j);

        merge(a,mid,i,j);
    }

    public static void merge(int[] a, int mid, int i, int j) {
        int[] tmp = new int[j-mid];
        int index = 0;
        for (int k=mid+1;k<=j;++k) {
            tmp[index++] = a[k];
        }
        int k=j, left=mid, right=index-1;

        while (left >= i && right >= 0) {
            if (tmp[right] >= a[left]) a[k--] = tmp[right--];
            else a[k--] = a[left--];
        }
        while (right >= 0) a[k--] = tmp[right--];
    }
}