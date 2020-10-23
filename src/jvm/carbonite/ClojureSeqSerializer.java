package carbonite;

import clojure.lang.RT;
import clojure.lang.Var;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;

import java.io.Serializable;

/** User: sritchie Date: 1/21/12 Time: 8:09 PM */
public class ClojureSeqSerializer extends ClojureCollSerializer implements Serializable {
  final transient Var readSeq;

  public ClojureSeqSerializer() {
    readSeq = RT.var("carbonite.serializer", "read-seq");
  }

  public Object read(Kryo kryo, Input input, Class aClass) {
    return readSeq.invoke(kryo, input);
  }
}
