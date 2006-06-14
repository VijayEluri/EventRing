### Makefile ###

PROGRAMS  = ers_test.bin arhr_test.bin er_test.bin str_util_test.bin
#PROGRAMS += r-test note-test note-player-test timer-test

SRC      = src
BIN      = bin
BUILD    = build
JC       = gcj
JCOPTS   = --classpath=build


all :  $(PROGRAMS)

##################################################

#VPATH = bin

vpath %.java src
vpath %.java src/net/lupulin
vpath %.java src/net/lupulin/event
vpath %.java src/net/lupulin/event/util
vpath %.java src/net/lupulin/net

vpath %.class build
vpath %.class build/net/lupulin
vpath %.class build/net/lupulin/event
vpath %.class build/net/lupulin/event/util
vpath %.class build/net/lupulin/net

%.class: %.java
	$(JC) $(JCOPTS) -C -d $(BUILD) $<
StringUtil.class: StringUtil.java StringUtilException.class
	$(JC) $(JCOPTS) -C -d $(BUILD) $<
MidiEvent.class: MidiEvent.java  AsciiRep.class    	   
	$(JC) $(JCOPTS) -C -d $(BUILD) $<
AsciiRep.class:  AsciiRep.java StringUtil.class EventException.class
	$(JC) $(JCOPTS) -C -d $(BUILD) $<
EventRingServer.class: EventRingServer.java EventRing.class  MultiSocketServer.class
	$(JC) $(JCOPTS) -C -d $(BUILD) $<
MultiSocketServer.class: MultiSocketServer.java SocketHandler.class
	$(JC) $(JCOPTS) -C -d $(BUILD) $<
EventRing.class: EventRing.java AbsEvent.class
	$(JC) $(JCOPTS) -C -d $(BUILD) $<
HashRep.class: HashRep.java AsciiRep.class 
	$(JC) $(JCOPTS) -C -d $(BUILD) $<

##################################################
#MidiNoteGenerator:      init                        MidiNoteGenerator.class
#EventException:         init                        EventException.class
#AbsEvent:               init                        AbsEvent.class
#SocketHandler:     init SocketHandler.class


### TESTING stuff ###
some-other-file.txt:
	touch some-other-file.txt
somefile.suf:
	touch somefile.suf
str-test.el: somefile.suf some-other-file.txt
	@echo str-test.el: somefile.suf some-other-file.txt
	@echo "$$\@:$(@)"
	@echo "$$\<:$<"
	@echo "$$\?:$?"
	@echo "$$\*:$*"
	@echo "$$\%:$%"
	@echo $(@:.el=.suf2)


ers_test: init AbsEvent.class MidiEvent.class EventRingServer.class HashRep.class \
	MultiSocketServer.class SocketHandler.class \
	ers_test.class
ers_test.bin: ers_test
	$(JC) $(BUILD)/$(@:.bin=.class)  \
	$(BUILD)/net/lupulin/event/EventRing.class                 \
	$(BUILD)/net/lupulin/event/EventRingServer.class                 \
	$(BUILD)/net/lupulin/event/MidiEvent.class		   \
	$(BUILD)/net/lupulin/event/AsciiRep.class		   \
	$(BUILD)/net/lupulin/event/HashRep.class		   \
	$(BUILD)/net/lupulin/event/AbsEvent.class		   \
	$(BUILD)/net/lupulin/event/util/StringUtil.class	   \
	$(BUILD)/net/lupulin/event/util/StringUtilException.class  \
	$(BUILD)/net/lupulin/event/EventException.class  \
	$(BUILD)/net/lupulin/net/MultiSocketServer.class \
	$(BUILD)/net/lupulin/net/SocketHandler.class \
	--main=$(@:.bin=) -o $(BIN)/$(@:.bin=)

arhr_test: init AsciiRep.class HashRep.class EventRing.class \
	MidiEvent.class arhr_test.class
arhr_test.bin: arhr_test
	$(JC) $(BUILD)/$(@:.bin=.class) \
	$(BUILD)/net/lupulin/event/EventRing.class                 \
	$(BUILD)/net/lupulin/event/MidiEvent.class		   \
	$(BUILD)/net/lupulin/event/AsciiRep.class		   \
	$(BUILD)/net/lupulin/event/HashRep.class		   \
	$(BUILD)/net/lupulin/event/AbsEvent.class		   \
	$(BUILD)/net/lupulin/event/util/StringUtil.class	   \
	$(BUILD)/net/lupulin/event/util/StringUtilException.class  \
	$(BUILD)/net/lupulin/event/EventException.class  \
	--main=$(@:.bin=) -o $(BIN)/$(@:.bin=)

er_test: init EventRing.class MidiEvent.class er_test.class
er_test.bin: er_test
	$(JC) $(BUILD)/$(@:.bin=.class)  \
	$(BUILD)/net/lupulin/event/EventRing.class                 \
	$(BUILD)/net/lupulin/event/MidiEvent.class		   \
	$(BUILD)/net/lupulin/event/AsciiRep.class		   \
	$(BUILD)/net/lupulin/event/AbsEvent.class		   \
	$(BUILD)/net/lupulin/event/util/StringUtil.class	   \
	$(BUILD)/net/lupulin/event/util/StringUtilException.class  \
	$(BUILD)/net/lupulin/event/EventException.class  \
	--main=$(@:.bin=) -o $(BIN)/$(@:.bin=)

str_util_test: init StringUtil.class str_util_test.class
str_util_test.bin: str_util_test
	$(JC) $(BUILD)/$(@:.bin=.class) \
	$(BUILD)/net/lupulin/event/util/StringUtil.class	   \
	$(BUILD)/net/lupulin/event/util/StringUtilException.class  \
	--main=$(@:.bin=) -o $(BIN)/$(@:.bin=)

##################################################
.PHONY  : clean  init                              
init:
	mkdir -p $(BUILD) $(BIN)
clean   :
	-rm -rf $(BUILD) $(BIN)
