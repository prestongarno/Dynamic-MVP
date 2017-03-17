# Dynamic-MVP
**Take the final step and completely decouple your MVP architecture with reusable event interfaces and event handling**

A developer implementing MVP into an application is always forced to make a decision: use a [Supervising Controller](https://martinfowler.com/eaaDev/SupervisingPresenter.html) or a [Passiive View](https://martinfowler.com/eaaDev/PassiveScreen.html). Dynamic-MVP solves this problem and allows for a clear separation between both.

Dynamic-MVP is a solution to this.

This library is a:
  * solution to the issues with standard Model-View-Presenter implementation such as: 
      * difficulty maintaining full dependency inversion 
      * Presentation-layer tests requiring mocks or stubs
      * boilerplate code (1:1 View to Presenter relationship)
  * annotation based library. Annotations are used to describe the relationship between a View and its Presenter(s)
  * compile-time annotation processor that eliminates the performance loss inherent to using Reflection (runtime) based solution, making it ideal, yet not specific to, embedded and mobile applications
  * event-driven library that also allows for re-usable event interfaces and handler implementations
  * library developed with the Android SDK specifically in mind. Memory leaks are not a concern as references to anonymous inner classes in the view are dropped at request and resolved at view recreation
  * direct effort to simplify callbacks to view events asynchronously  

***Tentative annotation definitions:***

__Presentation Layer__
| Name | Annotation Parameters | Definition
|  :---: | :---: | :---
| @EventHandler | Void |  Mark a method in Class\<T extends Presenter> that takes parameter \<T extends Event\>\n\t-called when a view broadcasts an event of this type to a presenter |
| @Callback | Void | Denotes functional interfaces that define callback parameters to a view |
| @Enforce | @Callback | Mark callback events that are independent of View broadcasting an event (e.g. an authorization event)|
| @LinkedCallback | @Callback | Define callback types in \<T extends Event> that are immutably linked (e.g. RequestUsernameEvent from a view will always call view's implementation of @Callback OnUsernameReturn interface) |
| @Default | class/method | include externally defined EventHandler(s) with a Presenter class (e.g. default error handling) |
| @State | \<T> | mark constructor parameters in \<T extends Event>, optional syntactical sugar |

__View Layer__
| Name | Annotation Parameters | Definition
|  :---: | :---: | :--- |
| @Presenter | Class\<T extends Presenter> | The presenter implementation to be used with this view |
| @Call | Void | non-private field or method returning @Callback interface implementation |

Modules:
      
1. [mvp-compiler](https://github.com/prestongarno/mvp-compiler) - annotation processor, dependency only needed at compile time
2. [dynamic-mvp](https://github.com/prestongarno/Dynamic-MVP) - runtime dependency
