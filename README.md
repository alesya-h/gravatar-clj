# gravatar

A Clojure/ClojureScript library to generate gravatar avatar urls

## Usage

Add `[gravatar "1.0.0"]` to your dependencies,
add `(:require [gravatar :refer avatar-url])` to your
namespace declaration. Then call `avatar-url` like
this:

```
user> (avatar-url "user@example.com")
;; "http://www.gravatar.com/avatar/b58996c504c5638798eb6b511e6f49af"
user> (avatar-url "user@example.com" :https true)
;; "https://secure.gravatar.com/avatar/b58996c504c5638798eb6b511e6f49af"
user> (avatar-url "user@example.com" :size 500)
;; "http://www.gravatar.com/avatar/b58996c504c5638798eb6b511e6f49af?size=512"
user> (avatar-url "user@example.com" :default "blank")
;; "http://www.gravatar.com/avatar/b58996c504c5638798eb6b511e6f49af?default=retro"
```

## License

Copyright © 2015 Ales Guzik

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
