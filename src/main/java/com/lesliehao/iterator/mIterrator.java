package com.lesliehao.iterator;

/**
 * @author HaoHao
 * @date 2020/3/9 5:26 下午
 */
public interface mIterrator<E>{

    boolean hasNext();

    /**
     * 返回当前原始 并指向下一个元素
     * @return
     */
    E next();

}
