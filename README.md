# Dynamic-MVP
Fully decoupled MVP architecture with reusable events and event handling

One of the main weaknesses of MVP is code reusability. This is followed up in close second by pure seperation of concerns.

A developer implementing MVP into an application is always forced to make a decision: use a [Supervising Controller](https://martinfowler.com/eaaDev/SupervisingPresenter.html) or a [Passiive View](https://martinfowler.com/eaaDev/PassiveScreen.html). Dynamic-MVP solves this problem and allows for a clear separation between both.

Dynamic-MVP aims to cut down on the amount of boilerplate code that is needed when creating the contract between the View and its associated Presenter by Annotation Processing (Meta-programming done at compile-time).
It also will allow for the Presenter to declare which Events are allowed to be sent from the view, and also provides the parameters for a callback event.  The View is left with the responsibility of implementing the definition set by the Presenter. (Examples will be provided)

Dynamic-MVP consists of two modules:
      1)  mvp-compiler - annotation processor, dependency only needed at compile time
      2)  dynamic-mvp - runtime dependency
