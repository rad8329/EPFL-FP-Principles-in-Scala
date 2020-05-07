package funsets

import org.junit._

/**
 * This class is a test suite for the methods in object FunSets.
 *
 * To run this test suite, start "sbt" then run the "test" command.
 */
class FunSetSuite {

  import FunSets._

  @Test def `contains is implemented`: Unit = {
    assert(contains(x => true, 100))
  }

  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   *
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   *
   * val s1 = singletonSet(1)
   *
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   *
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   *
   */

  trait TestSets {
    val s1: FunSet = singletonSet(1)
    val s2: FunSet = singletonSet(2)
    val s3: FunSet = singletonSet(3)

    val s4: FunSet = (x: Int) => x >= 10 && x <= 20
    val s5: FunSet = (x: Int) => x >= 12 && x <= 14
  }

  @Test def `exists is implemented`: Unit = {

    new TestSets {

      val s = union(s4, s5)

      assert(exists(s, (x: Int) => x >= 15 && x <= 19), "Predicate: x >= 15 && x <= 19")
      assert(!exists(s, (x: Int) => x > 0 && x < 10), "Predicate: x > 0 && x < 10")
    }
  }

  @Test def `forall is implemented`: Unit = {

    new TestSets {

      val s = union(s4, s5)

      assert(forall(s, (x: Int) => x >= 10 && x <= 20), "Predicate: x >= 10 && x <= 20")
      assert(!forall(s, (x: Int) => x > 0 && x < 10), "Predicate: x > 0 && x < 10")
    }
  }

  @Test def `map is implemented`: Unit = {

    new TestSets {

      val s = map(union(s4, s5), elem => elem * elem)

      assert(contains(s, 100), "map 10 --> 100")
      assert(contains(s, 400), "map 20 --> 400")
      assert(!contains(s, 10), "map 10")
    }
  }

  @Test def `singleton set one contains one`: Unit = {

    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3".
     */
    new TestSets {
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton")
    }
  }

  @Test def `contains all elements of each set`: Unit = {
    new TestSets {
      val s: FunSet = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }

  @Test def `contains only common elements of each set`: Unit = {
    new TestSets {
      val s: FunSet = intersect(s4, s5)
      assert(contains(s, 12), "intersect 12")
      assert(contains(s, 13), "intersect 13")
      assert(contains(s, 14), "intersect 14")
      assert(!contains(s, 11), "intersect 11")
    }
  }

  @Test def `contains some elements according to the filter`: Unit = {
    new TestSets {
      val s: FunSet = filter(intersect(s4, s5), x => x == 13 || x == 14)
      assert(contains(s, 13), "filter 13")
      assert(contains(s, 14), "filter 14")
      assert(!contains(s, 15), "filter 15")
    }
  }

  @Test def `contains the elements of set 4 - set 5`: Unit = {
    new TestSets {
      val s: FunSet = diff(union(s4, s5), s5)
      assert(contains(s, 10), "diff 10")
      assert(contains(s, 11), "diff 11")
      assert(contains(s, 19), "diff 19")
      assert(!contains(s, 13), "diff 13")
    }
  }

  @Rule def individualTestTimeout = new org.junit.rules.Timeout(10 * 1000)
}
