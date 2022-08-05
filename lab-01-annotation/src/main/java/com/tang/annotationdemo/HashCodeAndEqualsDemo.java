package com.tang.annotationdemo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Objects;

/*
* 当我们通过 k2的 hashCode到 100号位置查找时，确实会得到 k1。但 k1有可能仅仅是和 k2具有相同的 hash值，但未必和 k2相等（ k1和 k2两把钥匙未必能开同一扇门），这个时候，就需要调用 Key对象的 equals方法来判断两者是否相等了。

由于我们在 Key对象里没有定义 equals方法，系统就不得不调用 Object类的 equals方法。由于 Object的固有方法是根据两个对象的内存地址来判断，所以 k1和 k2一定不会相等，这就是为什么依然在 26行通过 hm.get(k2)依然得到 null的原因。

为了解决这个问题，我们需要打开第 9到 14行 equals方法的注释。在这个方法里，只要两个对象都是 Key类型，而且它们的 id相等，它们就相等。
* */

//@EqualsAndHashCode
class Key {
    private Integer id;
    public Integer getId;

    public Integer getId() {
        return id;
    }

    public Key(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Key key = (Key) o;
        return id.equals(key.id) && Objects.equals(getId, key.getId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getId);
    }
}

public class HashCodeAndEqualsDemo {
    public static void main(String[] args) {
        Key key = new Key(1);
        Key key1 = new Key(1);

        HashMap<Key, String> hashMap = new HashMap<>();
        hashMap.put(key, "this is key1");
        System.out.println(hashMap.get(key1));
    }
}
