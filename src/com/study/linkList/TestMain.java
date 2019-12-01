package com.study.linkList;


import com.study.common.Log;

/**
 * @author wuwei
 * @title: TestMain
 * @projectName DataStruct
 * @description: TODO
 * @date 2019-12-0113:25
 */
public class TestMain {
    private static final String TAG = TestMain.class.getSimpleName();
    public static void main(String[] args) {
        SingleList<String> singleList = new SingleList<>();
        Log.d(TAG, "delete....");
        singleList.delete("tail1");
        singleList.printAllNode();
        Log.d(TAG, "add....");
        singleList.insertFromTail("tail1");
        singleList.insertFromHead("1");
        singleList.insertFromHead("2");
        singleList.insertFromHead("3");
        singleList.insertFromTail("tail2");
        singleList.insertFromHead("4");
        singleList.insertFromHead("7");
        singleList.insertFromHead("1");
        singleList.insertFromHead("5");
        singleList.insertFromHead("6");
        singleList.insertFromHead("7");
        singleList.printAllNode();
        Log.d(TAG, "query....");
        Log.d(TAG, singleList.queryNode("5").toString());
        Log.d(TAG, singleList.queryNode("fuck") != null ? singleList.queryNode("fuck").toString() : "");
        Log.d(TAG, "delete....");
        singleList.delete("7");
        singleList.insertBefore(singleList.queryNode("5"), "insertBefore node");
        singleList.printAllNode();
    }
}
