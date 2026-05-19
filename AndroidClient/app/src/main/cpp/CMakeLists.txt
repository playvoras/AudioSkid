cmake_minimum_required(VERSION 3.22.1)
project("audio-skid")

set(CMAKE_BUILD_TYPE Release)

add_library(audio-skid SHARED
    native-lib.cpp
)

target_compile_options(audio-skid PRIVATE
    -Ofast
    -flto
    -march=armv8-a+simd
    -mtune=cortex-a55
    -ffast-math
    -funroll-loops
    -fomit-frame-pointer
    -fvisibility=hidden
    -fno-stack-protector
    -fno-exceptions
    -fno-rtti
    -fvectorize
    -fslp-vectorize
)

target_link_options(audio-skid PRIVATE
    -flto
    -Wl,--gc-sections
    -Wl,--icf=all
)

target_link_libraries(audio-skid
    log
    aaudio
)