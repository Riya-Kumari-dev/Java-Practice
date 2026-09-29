# HashMap

## What is HashMap

-  `HashMap<k,v>` is a class in java.util package that implements the map interface which is a part of the Java Collections Framework but **does not extend `Collection`**.

### ✨ Key Properties
- 🗝️ Keys are unique, but values can be duplicated.
- Inserting an existing key replaces its previous value.
- It allows one null key and multiple null values.
- It does not guarantee insertion or sorted order.
- It is not synchronized or inherently thread safe.

## ⚙️ Internal Working

A hashmap uses an array of buckets. A bucket may contain a single entry, a linked list of entries, or when conditions are met - a tree of entries.

A typical entry stores : 
```hash | key | value | next ```

🕐 **What happens during `put(key, value)`**

1. HashMap obtains and spreads the key's **hashCode()** (**null** is handled specially).
2. It calculates a bucket index from the hash and table capacity.
3. If an equal key is already in that bucket, its value is replaced.
4. Otherwise, a new entry is added.
5. If the size exceeds the threshold, HashMap may resize.

### hashCode() 🆚 equals()

| Method     | Responsibility                          |
|------------|-----------------------------------------|
| hashCode() | helps locate the bucket                 |
| equals()   | Checks whether keys are logically equal |

- If **a.equals(b)** is **true**, their hash codes must match. The reverse is not necessarily true.

```java
String a = new String("Java");
String b = new String("Java");
System.out.println(a == b); // false : different objects
System.out.println(a.equals(b)); // true : same contents
```
When both strings are used as keys, the second put replaces the first value.

## 💥 Hash collisions

A collision happens when distinct keys are assigned to the same bucket. It does not mean the keys are equal.

`Bucket 3 -> [10 -> Java] -> [20 -> Python] -> null`

Both entries remain if their keys are unequal. In modern Java, a heavily populated bucket can become a **Red-Black Tree**.

## 📏 Capacity, Load Factor and Resizing 

- **Default initial capacity** : 16 (table allocation is usually lazy)
- **Default load factor** : 0.75
- **Threshold** : capacity * load factor (normally)
- **Default threshold** : 16 * 0.75 = 12
- Inserting the 13th distinct entry normally triggers a resize from 16 -> 32 assuming ordinary conditions.
- During resizing, entries are redistributed into the larger table.

```java
Map<Integer, String> map = new HashMap<>(32, 0.75f); 
// initial capacity = 32
// first normal resize : 32 -> 64
```
⚠️ The threshold counts the entries in the whole map, not entries in the single bucket.

## 🌳 Treeification

Java's HashMap implementation uses these constants : 

| Constant             | Value | Role                                                   |
|----------------------|-------|--------------------------------------------------------|
| TREEIFY_THRESHOLD    | 8     | Threshold used when considering treeification          |
| MIN_TREEIFY_CAPACITY | 64    | Minimum table capacity for treeification               |
| UNTREEIFY_THRESHOLD  | 6     | Threshold used when converting tree bins back to lists |

When a crowded bucket needs treeification but the table capacity is below 64, HashMap prefers resizing first. Treeification improves operations on heavily collided buckets; it is not a guarantee of O(log n) for every possible key arrangement.