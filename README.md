# Guesser

Try to guess the next 0 or 1 in a sequence of 0s and 1s.

## Live

https://guesser2.web.app

## Build

[GitHub workflow](.github/workflows/main.yml)


## Details

### DI
DI implemented completely with `given`/`using` Scala 3 feature.

 - [define dependencies](https://github.com/s4ysolutions/guesser/blob/5bc233470641844ea2ff42c9c716d37ec0c604a8/src/main/scala/solutions/s4y/guesser/views/Scaffold.scala#L7C1-L10C54)
 - [satisfy dependencies](https://github.com/s4ysolutions/guesser/blob/5bc233470641844ea2ff42c9c716d37ec0c604a8/src/main/scala/solutions/s4y/guesser/Main.scala#L10C1-L21C53)

### I18N

 [README.md](src/main/scala/solutions/s4y/guesser/l18n/README.md)

## TODO:

- [ ] History panel grows beyond the container
- [ ] ML model to learn the behavior of the user