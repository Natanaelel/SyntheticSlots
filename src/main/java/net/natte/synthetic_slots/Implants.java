package net.natte.synthetic_slots;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

import static net.natte.synthetic_slots.item.ImplantCategory.*;

public class Implants {
    public static final List<Implant> IMPLANTS = new ArrayList<>();

    public static final Implant AUGMENT_BRAIN_CHIP       = register(new Implant("augment_brain_chip", "Augment Brain Chip", "Increases cognitive functions", "slight increase to xp gain", BRAIN));
    public static final Implant AUGMENT_SHIELD           = register(new Implant("augment_shield", "Augment Shield", "increases resistance to poison", "increases resistance to poison", IDK));
    public static final Implant AUGMENTED_NERVOUS_SYSTEM = register(new Implant("augmented_nervous_system", "Augmented Nervous System", "Enhances neural connections", "general buffs", IDK));
    public static final Implant BIO_FEEDBACK_SYSTEM      = register(new Implant("bio_feedback_system", "Bio Feedback System", "Monitors and optimizes bodily functions", "general small buffs", IDK));
    public static final Implant BIO_OPTIC_EYE            = register(new Implant("bio_optic_eye", "Bio Optic Eye", "Enhances visual acuity", "open to suggestions", EYE));
    public static final Implant BIO_SKELETON             = register(new Implant("bio_skeleton", "Bio Skeleton", "Reinforces the entire skeletal structure", "similar to cybernetic spine", IDK));
    public static final Implant CYBER_ARM                = register(new Implant("cyber_arm", "Cyber Arm", "Engineered for strength and precision", "more strength", ARM));
    public static final Implant CYBER_BRAIN              = register(new Implant("cyber_brain", "Cyber Brain", "Enhances brain functions", "significant boost in the xp you gain", BRAIN));
    public static final Implant CYBERNETIC_HAND          = register(new Implant("cybernetic_hand", "Cybernetic Hand", "Grants enhanced dexterity and strength", "Grants enhanced dexterity and strength", HAND));
    public static final Implant CYBERNETIC_SPINE         = register(new Implant("cybernetic_spine", "Cybernetic Spine", "Provides superior structural support", "negates fragility? like fall damage and running into things while flying", IDK));
    public static final Implant DATA_HUB                 = register(new Implant("data_hub", "Data Hub", "Centralizes all cybernetic data processing", "probably just an overall buff on some things", IDK));
    public static final Implant DIGITAL_RETINA           = register(new Implant("digital_retina", "Digital Retina", "Improves vision clarity", "not sure what to do here yet", EYE));
    public static final Implant ENERGY_CONVERTER         = register(new Implant("energy_converter", "Energy Converter", "all food gives you a little more hunger", "all food gives you a little more hunger", IDK));
    public static final Implant GIGA_EAR                 = register(new Implant("giga_ear", "Giga ear", "you can hear distant sounds? not sure how or if you could implement", "you can hear distant sounds? not sure how or if you could implement", IDK));
    public static final Implant HOLO_DISPLAY_ARM         = register(new Implant("holo_display_arm", "Holo Display Arm", "Projects holographic displays", "not sure, would be cool if we could just put overlayed icons on moving objects in view. or just mobs nearby.", EYE));
    public static final Implant HYDRAULIC_LIMBS          = register(new Implant("hydraulic_limbs", "Hydraulic Limbs", "grants superhuman strength", "grants superhuman strength", IDK));
    public static final Implant HYPER_LEGS               = register(new Implant("hyper_legs", "Hyper Legs", "Grants superhuman speed", "don’t go overboard with this.. just some speed", LEG));
    public static final Implant HYPER_VISION_LENS        = register(new Implant("hyper_vision_lens", "Hyper Vision Lens", "grants telescopic vision", "grants telescopic vision", EYE));
    public static final Implant IMPULSE_BOOSTER          = register(new Implant("impulse_booster", "Impulse Booster", "Increases reaction time", "slight speed increase", LEG)); // idea: acceleration
    public static final Implant MECH_JAW                 = register(new Implant("mech_jaw", "Mech Jaw", "Increases bite force and vocal abilities", "when unarmed, you can mine at a stone level pickaxe", IDK)); // you bite the rock?
    public static final Implant MECH_TENDONS             = register(new Implant("mech_tendons", "Mech Tendons", "faster and stronger buff", "faster and stronger buff", IDK));
    public static final Implant MIND_LINK                = register(new Implant("mind_link", "Mind Link", "Connects to external networks", "maybe just give the wearer the ability to peak into other’s inventory?\nopen to ideas", BRAIN));
    public static final Implant NANO_BLOODSTREAM         = register(new Implant("nano_bloodstream", "Nano Bloodstream", "Enhances bodily functions at the cellular level", "huge health boost", IDK));
    public static final Implant NANO_PROCESSOR           = register(new Implant("nano_processor", "Nano Processor", "small boost in xp received", "small boost in xp received", IDK));
    public static final Implant NANO_SKIN                = register(new Implant("nano_skin", "Nano Skin", "Provides superior protection", "perhaps some kind of armor rating addition", IDK));
    public static final Implant NANO_WEAVE_MUSCLE        = register(new Implant("nano_weave_muscle", "Nano Weave Muscle", "Strength Increase", "Strength Increase", IDK));
    public static final Implant NEURAL_INTERFACE         = register(new Implant("neural_interface", "Neural Interface", "Allows direct control of cybernetic systems", "Can access mekanism control panels from a long reach?", BRAIN));
    public static final Implant OPTIC_ENHANCER           = register(new Implant("optic_enhancer", "Optic Enhancer", "Enhances visual perception with augmented reality overlays", "not sure what to do here, possibly a zoom in?", EYE));
    public static final Implant PLASMA_PULSE_ARM         = register(new Implant("plasma_pulse_arm", "Plasma Pulse Arm", "increase attack", "increase attack", ARM));
    public static final Implant POWER_CORE               = register(new Implant("power_core", "Power Core", "Boosts energy reserves", "More stamina", IDK));
    public static final Implant PULSE_ENHANCER           = register(new Implant("pulse_enhancer", "Pulse Enhancer", "Boosts bio-electric pulse efficiency", "health regen faster", IDK));
    public static final Implant PULSE_WRIST              = register(new Implant("pulse_wrist", "Pulse Wrist", "Enhances pulse accuracy", "health regen faster", IDK));
    public static final Implant QUANTUM_INTERFACE        = register(new Implant("quantum_interface", "Quantum Interface", "Connects to quantum networks", "a few general buffs", IDK));
    public static final Implant SENSORY_MODULE           = register(new Implant("sensory_module", "Sensory Module", "Enhances sensory perception", "turns the volume up on environmental sounds when crouching?", IDK));
    public static final Implant SERVO_MOTOR_ARM          = register(new Implant("servo_motor_arm", "Servo Motor Arm", "increases attack strength", "increases attack strength", IDK));
    public static final Implant SYNTHETIC_HEART          = register(new Implant("synthetic_heart", "Synthetic Heart", "Ensures enhanced endurance and vitality", "slightly more health and stamina", IDK));
    public static final Implant SYNTHETIC_LUNGS          = register(new Implant("synthetic_lungs", "Synthetic Lungs", "Enhances respiratory efficiency", "aster stamina regen, can hold breath underwater longer", IDK));
    public static final Implant VIRTUAL_ASSISTANT_NODE   = register(new Implant("virtual_assistant_node", "Virtual Assistant Node", "Provides a virtual assistant", "be cool to plugin to tempad somehow", IDK));
    public static final Implant TECHNO_CORE              = register(new Implant("techno_core", "Techno Core", "General buffs", "General buffs", IDK));

    private static Implant register(Implant implant) {
        IMPLANTS.add(implant);
        return implant;
    }

    public static void register(IEventBus modBus) {

        DeferredRegister<Item> items = DeferredRegister.create(ForgeRegistries.ITEMS, SyntheticSlots.MOD_ID);
        for (Implant implant : IMPLANTS) {
            SyntheticSlots.LOGGER.info("registering implant " + implant.id);
            implant.register(items);
        }
        items.register(modBus);
    }
}
