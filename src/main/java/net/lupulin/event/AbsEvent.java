package net.lupulin.event;

public class AbsEvent {
  protected AsciiRep data;

  public AbsEvent(){}
  public AbsEvent( AsciiRep ar ){
      data = ar;
  }

  public String toString(){
      if( data != null){
          return( data.toString() );
      } else {
          return "NULL";
      }
  }

  public AsciiRep getData(){
      return data;
  }

  public void setData(AsciiRep ar){
      data = ar;
  }

}

