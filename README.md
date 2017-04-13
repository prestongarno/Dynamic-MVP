##<i>This is NOT part of any supported API. If you write code that depends on this, you do so at your own risk. This code and its internal interfaces are subject to change or deletion without notice.</i>
# Dynamic-MVP
**Take the final step and completely decouple your MVP architecture with reusable event interfaces and event handling**

A developer implementing MVP into an application is always forced to make a decision: use a [Supervising Controller](https://martinfowler.com/eaaDev/SupervisingPresenter.html) or a [Passiive View](https://martinfowler.com/eaaDev/PassiveScreen.html). Dynamic-MVP works around this with static checks and generation to provide the glue between the top application layers.

This library is a:
  * solution to the issues with standard Model-View-Presenter implementation such as: 
      * difficulty maintaining full dependency inversion which is usually solved by mocking/stubbing views
      * boilerplate code (1:1 View to Presenter relationship)
  * annotation based library. Annotations are used to describe the relationship between a View and its Presenter(s)
  * compile-time annotation processor that eliminates the performance loss inherent to using Reflection (runtime) based solution, making it ideal, yet not specific to, embedded and mobile applications
  * event-driven library that also allows for re-usable event interfaces and handler implementations
  * library developed with the Android SDK specifically in mind. References to anonymous inner classes (callbacks) in the view are dropped at request and resolved at view recreation relieving presenters from ever caring about the state of the view
  * In particular, this library also provides backwards compatibility for lambda expressions by transforming them to static methods or singletons, depending on the capture state
  * callbacks to view events asynchronously  
  
This also goes against standard practice by requiring implementation of an interface in the Presenter rather than the view.  //TODO automate this

__Presentation Layer__


| Name | Annotation Parameters | Definition |
|  --- | --- | ----------------------------- |
| `@Event`      | Void      | Mark a method or final field that defines an event with callback type |
| `@EventHandler` | Void | Parameter `Event\<T\>` called when a view broadcasts an event of this type to a presenter|
| `@Callback` | Void | Denotes functional interfaces that pass callback parameters to a view on same thread invoked|


__View Layer__

|  Name | Annotation Parameters | Definition |
| ----- | -------- | ------------- |
| `@Presenter` | Class | The presenter to be used with this view |

Modules:
      
1. [mvp-compiler](https://github.com/prestongarno/mvp-compiler) - compile
2. [dynamic-mvp](https://github.com/prestongarno/Dynamic-MVP) - classpath
