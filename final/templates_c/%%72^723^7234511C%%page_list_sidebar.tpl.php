<?php require_once(SMARTY_CORE_DIR . 'core.load_plugins.php');
smarty_core_load_plugins(array('plugins' => array(array('modifier', 'escapeurl', 'page_list_sidebar.tpl', 45, false),)), $this); ?>
<div class="sidebar-nav">

    <ul class="nav nav-pills nav-stacked">
        <?php echo $this->_tpl_vars['BeforeSidebarList']; ?>

        <?php $_from = $this->_tpl_vars['List']['Groups']; if (!is_array($_from) && !is_object($_from)) { settype($_from, 'array'); }if (count($_from)):
    foreach ($_from as $this->_tpl_vars['index'] => $this->_tpl_vars['Group']):
?>
            <?php $this->assign('GroupCaption', $this->_tpl_vars['Group']->getCaption()); ?>

            <?php if ($this->_tpl_vars['GroupCaption'] != 'Default'): ?>
                <li class="sidebar-nav-head">
                    <?php $this->assign('GroupIsActive', false); ?>
                    <?php $_from = $this->_tpl_vars['List']['Pages']; if (!is_array($_from) && !is_object($_from)) { settype($_from, 'array'); }if (count($_from)):
    foreach ($_from as $this->_tpl_vars['PageListPage']):
?>
                        <?php if ($this->_tpl_vars['PageListPage']['GroupName'] == $this->_tpl_vars['GroupCaption'] && $this->_tpl_vars['PageListPage']['IsCurrent']): ?>
                            <?php $this->assign('GroupIsActive', true); ?>
                        <?php endif; ?>
                    <?php endforeach; endif; unset($_from); ?>

                    <span data-toggle="collapse" data-target="#menu<?php echo $this->_tpl_vars['index']; ?>
" class="sidebar-nav-item<?php if (! $this->_tpl_vars['GroupIsActive']): ?> collapsed<?php endif; ?>">
                        <i class="icon-folder-o"></i>
                        <?php echo $this->_tpl_vars['GroupCaption']; ?>

                        <span class="caret"></span>
                    </span>

                    <ul class="nav nav-pills nav-stacked collapse<?php if ($this->_tpl_vars['GroupIsActive']): ?> in<?php endif; ?>" id="menu<?php echo $this->_tpl_vars['index']; ?>
">
            <?php endif; ?>
            <?php $_from = $this->_tpl_vars['List']['Pages']; if (!is_array($_from) && !is_object($_from)) { settype($_from, 'array'); }if (count($_from)):
    foreach ($_from as $this->_tpl_vars['PageListPage']):
?>
                <?php if ($this->_tpl_vars['PageListPage']['GroupName'] == $this->_tpl_vars['GroupCaption']): ?>

                    <?php if ($this->_tpl_vars['PageListPage']['BeginNewGroup']): ?>
                        <li class="nav-divider"></li>
                    <?php endif; ?>

                    <?php if ($this->_tpl_vars['PageListPage']['IsCurrent']): ?>
                        <li class="active<?php if ($this->_tpl_vars['PageListPage']['ClassAttribute']): ?> <?php echo $this->_tpl_vars['PageListPage']['ClassAttribute']; ?>
<?php endif; ?>" title="<?php echo $this->_tpl_vars['PageListPage']['Hint']; ?>
">
                            <span class="sidebar-nav-item">
                                <?php echo $this->_tpl_vars['PageListPage']['Caption']; ?>

                                <?php if ($this->_tpl_vars['List']['RSSLink']): ?>
                                    <a href="<?php echo $this->_tpl_vars['List']['RSSLink']; ?>
" class="pull-right link-icon">
                                        <i class="icon-rss"></i>
                                    </a>
                                <?php endif; ?>
                            </span>
                        </li>
                    <?php else: ?>
                        <li<?php if ($this->_tpl_vars['PageListPage']['ClassAttribute']): ?> class="<?php echo $this->_tpl_vars['PageListPage']['ClassAttribute']; ?>
"<?php endif; ?>>
                            <a class="sidebar-nav-item" href="<?php echo ((is_array($_tmp=$this->_tpl_vars['PageListPage']['Href'])) ? $this->_run_mod_handler('escapeurl', true, $_tmp) : smarty_modifier_escapeurl($_tmp)); ?>
" title="<?php echo $this->_tpl_vars['PageListPage']['Hint']; ?>
"<?php if ($this->_tpl_vars['PageListPage']['Target']): ?> target="<?php echo $this->_tpl_vars['PageListPage']['Target']; ?>
"<?php endif; ?>>
                                <?php echo $this->_tpl_vars['PageListPage']['Caption']; ?>

                            </a>
                        </li>
                    <?php endif; ?>

                <?php endif; ?>
            <?php endforeach; endif; unset($_from); ?>
            <?php if ($this->_tpl_vars['GroupCaption'] != 'Default'): ?>
                    </ul>
                </li>
            <?php endif; ?>
        <?php endforeach; endif; unset($_from); ?>
        <?php echo $this->_tpl_vars['AfterSidebarList']; ?>

    </ul>

</div>