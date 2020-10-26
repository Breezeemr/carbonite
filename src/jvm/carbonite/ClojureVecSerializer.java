package carbonite;

import clojure.lang.RT;
import clojure.lang.Var;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;

import java.io.Serializable;

/** User: sritchie Date: 1/21/12 Time: 8:13 PM */
public class ClojureVecSerializer extends ClojureCollSerializer implements Serializable {
  final Var readVec;

  public ClojureVecSerializer() {
    readVec = RT.var("carbonite.serializer", "read-vector");
  }

  public Object read(Kryo kryo, Input input, Class aClass) {
    return readVec.invoke(kryo, input);
  }
}
