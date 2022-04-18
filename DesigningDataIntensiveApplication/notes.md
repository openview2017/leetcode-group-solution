# Chapter 1 Reliable, Scalable and Maintainable Applications

## Reliability
> 所谓reliable：  在硬件不靠谱，软件不靠谱，人为失误等情况下，如果保证system能承受一些可以理解的fault，叫 fault tolerant或者resilient。这里说 “可理解的fault”，就是某一个或者两个component了不工作了 但是system能继续 continuely的 correctly的 工作（opposite就是整个system电线被拔了，地球毁灭了，这极端情况不再考虑范围）
> 硬件，软件，人为失误，三个角度去思考 如何避免, 或者发生了如何及时修复
> - Hardware Fault
  >   - what : hard disk crash  
  >   - why: old, too hot(happened in oci), other exceptions
  >   - how to prevent/resolve :
  >       - add redundancy to individual hardware components (备用)
  >       - raid configuration （？）
