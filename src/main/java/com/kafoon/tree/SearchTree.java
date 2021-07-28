package com.kafoon.tree;

public class SearchTree {

    private Node tree;

    public SearchTree(Node tree) {
        this.tree = tree;
    }

    public static void main(String[] args) {

    }

    public Node find(int data){

        if (tree == null) {
            return null;
        }

        Node p = tree;
        while(p != null){
            int pData = p.getData();
            if(data > pData) {
                p = p.getRight();
            } else if(data < pData) {
                p = p.getLeft();
            } else {
                return p;
            }
        }

        return null;
    }

    public void insert(int data){
        if (tree == null) {
            tree = new Node(data);
            return;
        }

        Node p = tree;
        while(p != null){
            int pData = p.getData();
            if(data > pData) {
                if(p.getRight() == null){
                    p.setRight(new Node(data));
                    return;
                }
                p = p.getRight();
            } else if(data < pData) {
                if(p.getLeft() == null){
                    p.setLeft(new Node(data));
                    return;
                }
                p = p.getLeft();
            } else {
                return ;
            }
        }
    }

    public void delete(int data){
        Node p = tree;
        Node pp = null;
        //首先定位到要删除的节点
        while(p != null && data != p.getData()){
            if(data < p.getData()){
                p = p.getLeft();
            }else {
                p = p.getRight();
            }
        }
        //没有找到要删除的节点
        if(p == null){
            return;
        }
        //要删除的节点存在两个子节点，找到右子树最小的节点，交换该点和需要删除的节点，将交换后的叶子节点从树上剥离
        if(p.getLeft() != null && p.getRight() != null){
            Node minPP= p;
            Node minP = p.getRight();
            //找到右子树最小的叶子节点，同时得记录它的父节点
            while(minP != null){
                if(minP.getLeft() != null){
                    minPP = minP;
                    minP = minP.getLeft();
                }
            }
            //将要删除的节点和右子树最小的点交换
            p.setData(minP.getData());
            pp = minPP;
            p = minP;
        }

        //走到这里，其实删除节点的情况，就只有：1、根节点本身；2、只有左节点；3、只有右节点
        Node child = null;
        if(p.getLeft() != null){
            child = p.getLeft();
        }else if(p.getRight() != null){
            child = p.getRight();
        }

        //所谓的删除，其实是将父节点指向该节点的引用指向child
        if(pp == null){
            tree = child;
        }else if(pp.getLeft() == p){
            pp.setLeft(child);
        }else {
            pp.setRight(child);
        }
    }

    public Node findMin(){
        if (tree == null) {
            return null;
        }

        Node p = tree;
        while(p != null){
            if(p.getLeft() != null) {
                p = p.getLeft();
            }
        }
        return p;
    }

    public Node findMax(){
        if (tree == null) {
            return null;
        }

        Node p = tree;
        while(p != null){
            if(p.getRight() != null) {
                p = p.getRight();
            }
        }
        return p;
    }





}
