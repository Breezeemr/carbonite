package carbonite;

/** User: sritchie Date: 1/20/12 Time: 2:33 PM */

import clojure.lang.RT;
import clojure.lang.Var;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.Serializable;

public class ClojureMapSerializer extends Serializer implements Serializable {
  final transient Var writeMap;
  final transient Var readMap;

  public ClojureMapSerializer() {
    JavaBridge.requireCarbonite();
    writeMap = RT.var("carbonite.serializer", "write-map");
    readMap = RT.var("carbonite.serializer", "read-map");
  }

  public void write(Kryo kryo, Output output, Object o) {
    writeMap.invoke(kryo, output, o);
  }

  public Object read(Kryo kryo, Input input, Class aClass) {
    return readMap.invoke(kryo, input);
  }
}
