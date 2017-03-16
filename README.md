# Dynamic-MVP
***Take the final step and completely decouple your MVP architecture with reusable event interfaces and event handling***

A developer implementing MVP into an application is always forced to make a decision: use a [Supervising Controller](https://martinfowler.com/eaaDev/SupervisingPresenter.html) or a [Passiive View](https://martinfowler.com/eaaDev/PassiveScreen.html). Dynamic-MVP solves this problem and allows for a clear separation between both.

Dynamic-MVP is a solution to this.

This library is a:
  * solution to the issues with standard Model-View-Presenter implementation namely: difficulty maintaining full dependency inversion, Presentation-layer testability requiring mocks or stubs, boilerplate code (1:1 View to Presenter relationship), and asynchronous integration with the main thread with callbacks to the View layer
  * annotation based library. Annotations are used to describe the relationship between a View and its Presenter(s)
  * compile-time annotation processor that eliminates the performance loss inherent to using Reflection (runtime) based solution.  This makes it ideal for embedded or mobile applications
  * event-driven library that allows for re-usable event interfaces

Dynamic-MVP consists of two modules:
      
1. [mvp-compiler](https://github.com/prestongarno/mvp-compiler) - annotation processor, dependency only needed at compile time
2. [dynamic-mvp](https://github.com/prestongarno/Dynamic-MVP) - runtime dependency
