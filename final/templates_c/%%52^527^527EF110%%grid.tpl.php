<div id="pgui-view-grid">
    <?php $_smarty_tpl_vars = $this->_tpl_vars;
$this->_smarty_include(array('smarty_include_tpl_file' => "page_header.tpl", 'smarty_include_vars' => array('pageTitle' => $this->_tpl_vars['Grid']['Title'])));
$this->_tpl_vars = $_smarty_tpl_vars;
unset($_smarty_tpl_vars);
 ?>

    <div class="<?php if ($this->_tpl_vars['Grid']['FormLayout']->isHorizontal()): ?>form-horizontal<?php endif; ?>">

        <?php $_smarty_tpl_vars = $this->_tpl_vars;
$this->_smarty_include(array('smarty_include_tpl_file' => "forms/actions_view.tpl", 'smarty_include_vars' => array('top' => true,'isHorizontal' => $this->_tpl_vars['Grid']['FormLayout']->isHorizontal())));
$this->_tpl_vars = $_smarty_tpl_vars;
unset($_smarty_tpl_vars);
 ?>

        <div class="row">
            <div class="col-md-12 js-message-container"></div>
            <div class="clearfix"></div>

            <div class="form-static <?php if ($this->_tpl_vars['Grid']['FormLayout']->isHorizontal()): ?>form-horizontal col-lg-8<?php else: ?>col-md-8 col-md-offset-2<?php endif; ?>">
                <?php $_smarty_tpl_vars = $this->_tpl_vars;
$this->_smarty_include(array('smarty_include_tpl_file' => 'forms/form_fields.tpl', 'smarty_include_vars' => array('isViewForm' => true)));
$this->_tpl_vars = $_smarty_tpl_vars;
unset($_smarty_tpl_vars);
 ?>
            </div>
        </div>

        <?php $_smarty_tpl_vars = $this->_tpl_vars;
$this->_smarty_include(array('smarty_include_tpl_file' => "forms/actions_view.tpl", 'smarty_include_vars' => array('top' => false,'isHorizontal' => $this->_tpl_vars['Grid']['FormLayout']->isHorizontal())));
$this->_tpl_vars = $_smarty_tpl_vars;
unset($_smarty_tpl_vars);
 ?>
    </div>
</div>