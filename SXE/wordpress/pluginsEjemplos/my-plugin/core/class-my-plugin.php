<?php

// Exit if accessed directly.
if ( ! defined( 'ABSPATH' ) ) exit;
if ( ! class_exists( 'My_Plugin' ) ) :

	/**
	 * Main My_Plugin Class.
	 *
	 * @package		MYPLUGIN
	 * @subpackage	Classes/My_Plugin
	 * @since		1.0.0
	 * @author		Angel
	 */
	final class My_Plugin {

		/**
		 * The real instance
		 *
		 * @access	private
		 * @since	1.0.0
		 * @var		object|My_Plugin
		 */
		private static $instance;

		/**
		 * MYPLUGIN helpers object.
		 *
		 * @access	public
		 * @since	1.0.0
		 * @var		object|My_Plugin_Helpers
		 */
		public $helpers;

		/**
		 * MYPLUGIN settings object.
		 *
		 * @access	public
		 * @since	1.0.0
		 * @var		object|My_Plugin_Settings
		 */
		public $settings;

		/**
		 * Throw error on object clone.
		 *
		 * Cloning instances of the class is forbidden.
		 *
		 * @access	public
		 * @since	1.0.0
		 * @return	void
		 */
		public function __clone() {
			_doing_it_wrong( __FUNCTION__, __( 'You are not allowed to clone this class.', 'my-plugin' ), '1.0.0' );
		}

		/**
		 * Disable unserializing of the class.
		 *
		 * @access	public
		 * @since	1.0.0
		 * @return	void
		 */
		public function __wakeup() {
			_doing_it_wrong( __FUNCTION__, __( 'You are not allowed to unserialize this class.', 'my-plugin' ), '1.0.0' );
		}

		/**
		 * Main My_Plugin Instance.
		 *
		 * Insures that only one instance of My_Plugin exists in memory at any one
		 * time. Also prevents needing to define globals all over the place.
		 *
		 * @access		public
		 * @since		1.0.0
		 * @static
		 * @return		object|My_Plugin	The one true My_Plugin
		 */
		public static function instance() {
			if ( ! isset( self::$instance ) && ! ( self::$instance instanceof My_Plugin ) ) {
				self::$instance					= new My_Plugin;
				self::$instance->base_hooks();
				self::$instance->includes();
				self::$instance->helpers		= new My_Plugin_Helpers();
				self::$instance->settings		= new My_Plugin_Settings();

				//Fire the plugin logic
				new My_Plugin_Run();

				/**
				 * Fire a custom action to allow dependencies
				 * after the successful plugin setup
				 */
				do_action( 'MYPLUGIN/plugin_loaded' );
			}

			return self::$instance;
		}

		/**
		 * Include required files.
		 *
		 * @access  private
		 * @since   1.0.0
		 * @return  void
		 */
		private function includes() {
			require_once MYPLUGIN_PLUGIN_DIR . 'core/includes/classes/class-my-plugin-helpers.php';
			require_once MYPLUGIN_PLUGIN_DIR . 'core/includes/classes/class-my-plugin-settings.php';

			require_once MYPLUGIN_PLUGIN_DIR . 'core/includes/classes/class-my-plugin-run.php';
		}

		/**
		 * Add base hooks for the core functionality
		 *
		 * @access  private
		 * @since   1.0.0
		 * @return  void
		 */
		private function base_hooks() {
			add_action( 'plugins_loaded', array( self::$instance, 'load_textdomain' ) );
		}

		/**
		 * Loads the plugin language files.
		 *
		 * @access  public
		 * @since   1.0.0
		 * @return  void
		 */
		public function load_textdomain() {
			load_plugin_textdomain( 'my-plugin', FALSE, dirname( plugin_basename( MYPLUGIN_PLUGIN_FILE ) ) . '/languages/' );
		}

	}

endif; // End if class_exists check.